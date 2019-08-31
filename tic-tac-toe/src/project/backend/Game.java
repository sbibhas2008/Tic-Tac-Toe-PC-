package project.backend;

public class Game {
	
	private Board board;
	
	public Game (Board b) {
		this.board = b;
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
	

}
