package project.backend;

import javafx.beans.property.IntegerProperty;

public class Game {
	
	private Board board;
	private int moves;
	int humanPlayer;
	
	int AIplayer;
	public Game (int player) {
		this.board = new Board();
		moves = 0;
		humanPlayer = player;
		AIplayer = (player + 1) % 2;
		
	}
	
	public void terminateGame (int x, int y) {
		if (board.checkCurrSate(x, y) != -1) {
			System.out.println("Stop");
		}
	}
	
	public boolean setX(int x, int y) {
		boolean check = board.setX(x, y);
		return check;
	}
	
	public boolean setO(int x, int y) {
		boolean check = board.setO(x, y);
		return check;
	}
	
	public int setMove (int x, int y) {
		int check = board.getCoordinate(x, y);
		if (this.moves % 2 == 0) {
			boolean see = board.setO(x, y);
			if (see) {
				check = board.getCoordinate(x, y);
				moves++;
			}
		}
		else {
			boolean see = board.setX(x, y);
			if (see) {
				check = board.getCoordinate(x, y);
				moves++;
			}
		}
		
		terminateGame(x, y);
		return check;
	}
	
	public void setVal(int x, int y, int player) {
		if (player == 0) {
			board.setO(x, y);
		}
		else {
			board.setX(x, y);
		}
	}
	
	public int getVal (int x, int y) {
		return board.getCoordinate(x,y);
	}
	
	public int checkVictory(int x, int y) {
		return board.checkCurrSate(x, y);
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

 	

}
