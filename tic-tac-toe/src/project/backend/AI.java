package project.backend;

public class AI {
	
	int x;
	int y;
	int score;
	Game game;
	
	public AI (Game game) {
		this.game = game;
	}
	
	public void performMove() {
		
	}
	
	// perform a minimax search of depth 3
	public void miniMax(int x, int y, int depth, int player) {
		// checks if AI has won
		if (game.checkVictory(x, y) == game.getAIplayer()) {
			score = 10 - depth;
		}
		// human player
		else if (game.checkVictory(x, y) == game.getHumanPlayer()) {
			score = depth - 10;
		}
		else if (game.checkVictory(x, y) == -1) {
			score = 0;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (game.getVal(x, y) == -1) {
					this.x = j;
					this.y = i;
					game.setVal(x, y, player);
					if (player == game.getAIplayer()) {
						score = minimax(this.x, this.y, )
					}
					else {
						
					}
				}
			}
		}
		
		
	}

}
