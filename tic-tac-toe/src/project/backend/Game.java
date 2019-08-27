package project.backend;

public class Game {
	
	private Board board;
	
	public Game (Board b) {
		this.board = b;
	}
	
	public void terminateGame () {
		if (board.checkCurrSate()) {
			System.out.println("Stop");
		}
	}
	

}
