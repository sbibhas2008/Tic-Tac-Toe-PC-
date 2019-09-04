package project.backend;

public class AI {
	
	int x;
	int y;
	int score;
	Board b;
	
	public AI (Board b) {
		this.b = b;
	}
	
	public void performMove() {
		
	}
	
	// perform a minimax search of depth 3
	public void miniMax(int x, int y, int depth) {
		if (b.checkCurrSate(x, y)) {
			score = 10 - depth;
		}
		
		
	}
	
	public int score(int x, int y, int depth) {
		if (b.checkCurrSate(x, y)) {
			return 10 - depth;
		}
		else if (b.checkCurrSate(x, y))
	}

}
