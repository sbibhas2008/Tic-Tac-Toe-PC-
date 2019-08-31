package project.backend;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Board {
	
	private IntegerProperty[][] grid = new IntegerProperty [3][3];
		
	public Board () {
		/*   grid
		 * 00 01 02
		 * 10 11 12
		 * 20 21 22
		 */
		
		// initialize the grid all to -1 (empty)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = new SimpleIntegerProperty(-1);
			}
		}
	}
	
	private boolean validCoordinate(int x, int y) {
		if (x > 2 || x < 0 || y > 2 || y < 0) {
			System.out.println("in false");
			return false;
		} 
		else if (grid[x][y].get() != -1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean setX (int x, int y) {
		// check valid co-ordinates
		if (validCoordinate(x,y)) {
			grid[x][y].setValue(1);
			return true;
		}
		return false;
	}
	
	public boolean setO (int x, int y) {
		// check valid co-ordinates
		if (validCoordinate(x,y)) {
			grid[x][y].setValue(0);
			return true;
		}
		return false;
	}
	
	/*
	 * return value: true if game can continue
	 * 				 false if game is over
	 */
	public boolean checkCurrSate(int x, int y) {

		// temporary to remove error highlights
		boolean free = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j].get() == -1) {
					free = true;
					break;
				}
			}
			if (free) break;
		}
		boolean won = false;
		// check win condition
		if (checkStraight(x,y) || checkDiagonal(x,y)) {
			won = true;
		}
		
		if (!won || (!free)) {
			return false;
		}
		return true;
		
	}
	
	private boolean checkStraight(int x, int y) {
		int current = grid[x][y].get();
		if (current == -1) return false;
		//vertical
		boolean match = true;
		int c = 0;
		int i = x;
		while (c < 3 && match) {
			i = i % 3;
			if (grid[i][y].get() != current) {
				match = false;
			}
			c++;
			i++;
		}
		
		//horizontal
		if (match) return true;
		match = true;
		c = 0;
		int j = y;
		while (c < 3 && match) {
			j = j % 3;
			if (grid[x][j].get() != current) {
				match = false;
			}
			c++;
			j++;
		}
		return match;
	}
	
	private boolean checkDiagonal(int x, int y) {
		int current = grid[x][y].get();
		if (current == -1) return false;
		if (y == 1 && (x == 0 || y == 2)) {
			return false;
		} else if (x == 1 && (y == 0 || y == 1)) {
			return false;
		}
		boolean match = true;
		for (int i = 0; i < 3; i++) {
			if (grid[i][i].get() != current) {
				match = false;
				break;
			}
		}
		if (! match) {
			match = true;
			int i = 2;
			int j = 0;
			while (i >= 0 && match) {
				if (grid[i][j].get() != current) {
					match = false;
				}
				i -= 1;
				j += 1;
			}
		}
		return match;
	}
	
	public IntegerProperty getproperty (int x, int y) {
		return grid[x][y];
	}
	


}
