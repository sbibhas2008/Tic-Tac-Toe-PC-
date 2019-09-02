package project.backend;

import javafx.beans.property.IntegerProperty;

public class Game {
	
	private Board board;
	private int moves;
	public Game () {
		this.board = new Board();
		moves = 0;
	}
	
	public void terminateGame (int x, int y) {
		if (board.checkCurrSate(x, y)) {
			System.out.println("Stop");
		}
	}
	
	public boolean setX(int x, int y) {
		boolean check = board.setX(x, y);
		terminateGame(x, y);
		return check;
	}
	
	public boolean setO(int x, int y) {
		boolean check = board.setO(x, y);
		terminateGame(x, y);
		return check;
	}
	
	public int setMove (int x, int y) {
		int check = board.getCoordinate(x, y);
		if (this.moves % 2 == 0) {
			boolean see = board.setO(x, y);
			if (see) {
				check = board.getCoordinate(x, y);
			}
		}
		else {
			boolean see = board.setX(x, y);
			if (see) {
				check = board.getCoordinate(x, y);
			}
		}
		moves++;
		return check;
	}
	
	public IntegerProperty getproperty (int x, int y) {
		return board.getproperty(x, y);
	}
	

}
