public class GameDriver {

	public static void main(String[] args) {
		Player p1 = new HumanPlayer();
		Player p2 = new HumanPlayer();
		Game game = new TicTacToe(p1, p2);

		while(true) {
			// Get the current move from the active player

			// Get the current legal moves from the game

			// Apply the current move if the current move returned by the active player is a legal move in the game

			// End the game if the current active player or inactive player has won the game
		}
	}
}
