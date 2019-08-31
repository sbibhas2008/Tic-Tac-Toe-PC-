package project.tests;

import org.junit.Test;

import project.backend.Board;
import project.backend.Game;

public class TestClass {
	
	@Test
	public void checkBoardDiagonal() {
		Board board = new Board();
		Game game = new Game(board);
		assert board.checkCurrSate(0, 0) == false;
		assert game.setO(0, 0) == true;
		assert game.setX(0, 0) == false;
		assert game.setO(1, 1) == true;
		assert game.setO(2, 2) == true;
		assert board.checkCurrSate(0, 0) == true;
	}
	
	@Test
	public void checkBoardStraight() {
		Board board = new Board();
		Game game = new Game(board);
		assert board.checkCurrSate(0, 0) == false;
		assert game.setO(0, 0) == true;
		assert game.setX(0, 0) == false;
		assert game.setO(0, 1) == true;
		assert game.setO(0, 2) == true;
		assert board.checkCurrSate(0, 2) == true;
	}
	
	@Test
	public void checkBoardDiagonalOpposite() {
		Board board = new Board();
		Game game = new Game(board);
		assert board.checkCurrSate(0, 0) == false;
		assert game.setO(2, 0) == true;
		assert game.setX(2, 0) == false;
		assert game.setO(1, 1) == true;
		assert game.setO(0, 2) == true;
		assert board.checkCurrSate(0, 2) == true;
	}
	

}
