package project.tests;

import org.junit.Test;

import project.backend.Board;
import project.backend.Game;

public class TestClass {
	
	@Test
	public void checkBoard() {
		Board board = new Board();
		Game game = new Game(board);
		assert board.checkCurrSate(0, 0) == true;
	}
	

}
