package project.backend;

public class Board {
	
	private int[][] grid;
	private int lastX;
	private int lastY;
	
	public Board () {
		/*   grid
		 * 00 01 02
		 * 10 11 12
		 * 20 21 22
		 */
		
		// initialize the grid all to -1 (empty)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = -1;
			}
		}
	}
	
	private boolean validCoordinate(int x, int y) {
		if (x > 2 || x < 0 || y > 2 || y < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setX (int x, int y) {
		// check valid co-ordinates
		if (validCoordinate(x,y)) {
			grid[x][y] = 1;
		}
	}
	
	public void setO (int x, int y) {
		// check valid co-ordinates
		if (validCoordinate(x,y)) {
			grid[x][y] = 0;
		}
	}
	
	/*
	 * return value: true if game can continue
	 * 				 false if game is over
	 */
	public boolean checkCurrSate() {

		// temporary to remove error highlights
		boolean free = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == -1) {
					free = true;
					break;
				}
			}
			if (free) break;
		}
		boolean won = false;
		// check win condition
		if (won || (!free)) {
			return false;
		}
		return true;
		
	}
	
	public void checkDiagonal(int x, int y) {
		
	}
	


}
