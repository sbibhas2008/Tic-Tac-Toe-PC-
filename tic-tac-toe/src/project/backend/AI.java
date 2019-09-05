package project.backend;

import java.util.ArrayList;

public class AI {
	
	
	Game game;
	
	public AI (Game game) {
		this.game = game;
	}
	
	public AIMove performMove() {
		AIMove bestMove = miniMax(3, game.getAIplayer());
		game.setVal(bestMove.getX(), bestMove.getY(), game.getAIplayer());
		return bestMove;
	}
	
	// perform a minimax search of depth 3
	public AIMove miniMax(int depth, int player) {
		// checks if AI has won
		if (game.checkVictory() == game.getAIplayer()) {
			return new AIMove(10 - depth);
		}
		// human player
		else if (game.checkVictory() == game.getHumanPlayer()) {
			return new AIMove(depth - 10);
		}
		else if (game.checkVictory() == -1) {
			return new AIMove(0);
		}
		depth += 1;
		System.out.println("Here");

		ArrayList<AIMove> moves  = new ArrayList<>();
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (game.getVal(x, y) == -1) {
					AIMove move = new AIMove();
					move.setX(x);
					move.setY(y);
					game.setVal(x, y, player);
					if (player == game.getAIplayer()) {
						move.setScore(miniMax(depth, game.getHumanPlayer()).getScore());
					}
					else {
						move.setScore(miniMax(depth, game.getAIplayer()).getScore());
					}
					moves.add(move);
					game.setVal(x, y, -1);
				}
			}
		}
		
		int bestMove = 0;
		if (player == game.getAIplayer()) {
			int bestScore = -10000000;
			for (int i = 0; i < moves.size(); i++) {
				if (moves.get(i).getScore() > bestScore) {
					bestMove = i;
					bestScore = moves.get(i).getScore();
				}
			}
		}
		else {
			int bestScore = 10000000;
			for (int i = 0; i < moves.size(); i++) {
				if (moves.get(i).getScore() < bestScore) {
					bestMove = i;
					bestScore = moves.get(i).getScore();
				}
			}
		}
		
		return moves.get(bestMove);
		
	}

}
