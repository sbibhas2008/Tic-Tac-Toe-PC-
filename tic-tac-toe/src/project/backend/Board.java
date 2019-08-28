package project.backend;

public class Board {
	
	private int[][] grid;
	private int lastX;
	private int lastY;
	
	public Board () {
		// initialize the grid all to -1 (empty)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = -1;
			}
		}
	}
	
	public void setX (int x, int y) {
		// check valid co-ordinates
		if (x > 2 || x < 0 || y > 2 || y < 0) {
			return;
		} else {
			grid[x][y] = 1;
		}
	}
	
	public void setO (int x, int y) {
		// check valid co-ordinates
		if (x > 2 || x < 0 || y > 2 || y < 0) {
			return;
		} else {
			grid[x][y] = 0;
		}
	}
	
	public boolean checkCurrSate() {
		// temporary to remove error highlights
		return true;
		
	}
	
	public void checkDiagonal(int x, int y) {
		
	}
	


}
