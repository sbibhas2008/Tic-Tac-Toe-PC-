package project.backend;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;

public class Game {
	
	private Board board;
	private int moves;
	int humanPlayer;
	int AIplayer;
	AI ai;
	
	public AI getAi() {
		return ai;
	}

	public void setAi(AI ai) {
		this.ai = ai;
	}

	public Game (int player) {
		this.board = new Board();
		this.ai = new AI(this);
		moves = 0;
		humanPlayer = player;
		AIplayer = (player + 1) % 2;
		
	}
	
	public Game () {
		this.board = new Board();
		moves = 0;
		humanPlayer = 0;
		AIplayer = 1;
	}
	
	public int terminateGame () {
		return board.checkCurrSate();
	}
	
	public boolean setX(int x, int y) {
		boolean check = board.setX(x, y);
		return check;
	}
	
	public boolean setO(int x, int y) {
		boolean check = board.setO(x, y);
		return check;
	}
	
	// returns (x,y,move) as tuple
	public ArrayList<Integer> setMove (int x, int y) {
		ArrayList<Integer> tuple = new ArrayList<>(3);
		for (int i = 0; i < 3; i++) {
			tuple.add(i, -1);
		}
		tuple.add(2, board.getCoordinate(x, y));
		if (this.ai == null) {
			if (this.moves % 2 == 0) {
				boolean see = board.setX(x, y);
				if (see) {
					tuple.add(2,board.getCoordinate(x, y));
					moves++;
				}
			}
			else if (this.moves % 2 == 1) {
				boolean see = board.setO(x, y);
				if (see) {
					tuple.add(2,board.getCoordinate(x, y));
					moves++;
				}
			}
			terminateGame();
			return tuple;
		}
		// if ai is playing
		else {
			if (this.moves % 2 == 0) {
				if (AIplayer == 1) {
					AIMove move = ai.performMove();
					moves++;
					tuple.add(0, move.getX());
					tuple.add(1, move.getY());
					tuple.add(2, 1);
				}
				else  {
					boolean see = board.setX(x, y);
					if (see) {
						tuple.add(2,board.getCoordinate(x, y));
						moves++;
					}
				}
			}
			else {
				if (AIplayer == 0) {
					moves++;
					AIMove move = ai.performMove();
					tuple.add(0, move.getX());
					tuple.add(1, move.getY());
					tuple.add(2, 0);
				}
				else  {
					boolean see = board.setO(x, y);
					if (see) {
						tuple.add(2,board.getCoordinate(x, y));
						moves++;
					}
				}
				
			}
		}
		System.out.println(moves);
//		terminateGame();
		return tuple;
	}
	
	public void setVal(int x, int y, int player) {
		if (player == 0) {
			board.setO(x, y);
		}
		else if (player == 1){
			board.setX(x, y);
		}
		else {
			board.setNone(x, y);
		}
	}
	
	public int getVal (int x, int y) {
		return board.getCoordinate(x,y);
	}
	
	public int checkVictory() {
		return board.checkCurrSate();
	}
	
	public int getHumanPlayer() {
		return humanPlayer;
	}

	public void setHumanPlayer(int humanPlayer) {
		this.humanPlayer = humanPlayer;
	}

	public int getAIplayer() {
		return AIplayer;
	}

	public void setAIplayer(int aIplayer) {
		AIplayer = aIplayer;
	}
	
	public void showBoard() {
		board.showBoard();
	}

 	

}
