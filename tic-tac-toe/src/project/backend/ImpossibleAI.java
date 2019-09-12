package project.backend;

public class ImpossibleAI extends AI{

	public ImpossibleAI(Game game) {
		super(game);
	}

	@Override
	public AIMove performMove() {
		AIMove bestMove = miniMax(1, game.getAIplayer());
		game.setVal(bestMove.getX(), bestMove.getY(), game.getAIplayer());
		return bestMove;
	}

}
