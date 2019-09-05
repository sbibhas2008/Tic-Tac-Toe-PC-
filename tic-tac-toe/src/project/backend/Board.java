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
	 * return value:
	 * 				 1 if game won by X
	 * 				 0 if game won by O
	 * 				-1 otherwise
	 */
	public int checkCurrSate() {

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				// check win condition
				if (checkStraight(x,y) || checkDiagonal(x,y)) {
					//if won
					int current = grid[x][y].get();
					return current;
				}
			}
		}
		return -1;
		
	}
	
	private boolean checkStraight(int x, int y) {
		int current = grid[x][y].get();
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
	
	public int getCoordinate(int x, int y) {
		return grid[x][y].get();
	}
	
	public void showBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(grid[j][i].get() + " ");
			}
			System.out.print("\n");
		}
	}

}
