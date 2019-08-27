package project.backend;

public class Board {
	
	private int[][] grid;
	
	public Board () {
		// initialise the grid all to -1 (empty)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = -1;
			}
		}
	}
	
	public void setX (int x, int y) {
		grid[x][y] = 1;
	}
	
	public void setO (int x, int y) {
		grid[x][y] = 0;
	}
	
	public boolean checkCurrSate(int x, int y) {
		
		
	}
	
	public void checkDiagonal(int x, int y) {
		
	}
	


}
