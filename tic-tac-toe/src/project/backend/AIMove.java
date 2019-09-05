package project.backend;

public class AIMove {
	
	private int x;
	private int y;
	private int score;
	
	public AIMove() {
		
	}
	
	public AIMove(int score) {
		this.score = score;
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
