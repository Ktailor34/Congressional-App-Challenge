import java.util.List;

public interface Game {
	// Draws the current board to screen
	void drawBoard();

	// Applies move to game board and switches active and inactive players
	void applyMove(Move move);

	// Creates an exact copy of the current Game and returns copy
	Game copy();

	// Uses the copy method above to create a copy of the game and uses the apply move method on new game copy to
	// forecast what the game would look like after applying this move.
	Game forecastMove(Move move);

	// Returns the current active player
	Player getActivePlayer();

	// Returns the current inactive player
	Player getInactivePlayer();

	// Returns a list of legal moves that the active player can make as move objects
	List<Move> getLegalMoves();

	// Returns a list of legal moves that the inactive player can make as move objects
	List<Move> getOpponentMoves();

	// Uses some win condition to determine if the current active player has won the game
	boolean isWinner(Player player);

	// Uses some win condition to determine if the current inactive player has won the game
	boolean isOpponentWinner(Player player);
}
