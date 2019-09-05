package project.tests;

import org.junit.Test;

import project.backend.Board;
import project.backend.Game;

public class TestClass {
	
	@Test
	public void checkBoardDiagonal() {
		Game game = new Game(0);
		assert game.checkVictory() == -1;
		assert game.setO(0, 0) == true;
		assert game.setX(0, 0) == false;
		assert game.setO(1, 1) == true;
		assert game.setO(2, 2) == true;
		assert game.checkVictory() == 0;
	}
	
	@Test
	public void checkBoardStraight() {
		Game game = new Game(0);
		assert game.checkVictory() == -1;
		assert game.setO(0, 0) == true;
		assert game.setX(0, 0) == false;
		assert game.setO(0, 1) == true;
		assert game.setO(0, 2) == true;
		assert game.checkVictory() == 0;
	}
	
	@Test
	public void checkBoardDiagonalOpposite() {
		Game game = new Game(0);
		assert game.checkVictory() == -1;
		assert game.setO(2, 0) == true;
		assert game.setX(2, 0) == false;
		assert game.setO(1, 1) == true;
		assert game.setO(0, 2) == true;
		assert game.checkVictory() == 0;
	}
	
	@Test
	public void checkDraw() {
		Game game = new Game(0);
		assert game.setO(0,0) == true;
		assert game.setX(0,1) == true;
		assert game.setO(0,2) == true;
		assert game.setX(1,0) == true;
		assert game.setO(1,1) == true;
		assert game.setX(1,2) == true;
		assert game.setX(2,0) == true;
		assert game.setO(2,1) == true;
		assert game.setX(2,2) == true;
		assert game.checkVictory() == 2;
	}

}
