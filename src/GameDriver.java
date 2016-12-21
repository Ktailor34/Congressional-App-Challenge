import java.util.List;

public class GameDriver {

	public static void main(String[] args) {
		Player p1 = new HumanPlayer();
		Player p2 = new HumanPlayer();
		Game genericGame = new TicTacToe(p1, p2);

		while(true) {
			Move CurrMove = genericGame.getActivePlayer().move(genericGame);
			// Get the current move from the active player

			List<Move> legalMoves = genericGame.getLegalMoves();
			// Get the current legal moves from the game

			if(legalMoves.contains(CurrMove)){
				genericGame.applyMove(CurrMove);
			}
			// Apply the current move if the current move returned by the active player is a legal move in the game

			//if(game.isWinner() || game.isOpponentWinner()){

		}
			// End the game if the current active player or inactive player has won the game
	}
}
