package project.backend;

import javafx.beans.property.IntegerProperty;

public class Game {
	
	private Board board;
	public Game () {
		this.board = new Board();
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
	
	public IntegerProperty getproperty (int x, int y) {
		return board.getproperty(x, y);
	}
	

}
