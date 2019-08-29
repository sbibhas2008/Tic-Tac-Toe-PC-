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
	
	public void setX(int x, int y) {
		board.setX(x, y);
		terminateGame(x, y);
	}
	
	public void setO(int x, int y) {
		board.setO(x, y);
		terminateGame(x, y);
	}
	

}
