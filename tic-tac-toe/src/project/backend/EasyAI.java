package project.backend;

public class EasyAI extends AI{

	public EasyAI(Game game) {
		super(game);
	}

	@Override
	public AIMove performMove() {
		AIMove bestMove = miniMax(8, game.getAIplayer());
		game.setVal(bestMove.getX(), bestMove.getY(), game.getAIplayer());
		return bestMove;
	}

}
