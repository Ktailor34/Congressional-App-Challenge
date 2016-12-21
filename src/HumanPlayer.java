import java.util.Scanner;

public class HumanPlayer implements Player {
	@Override
	public Move move(Game game) {
		Scanner scan = new Scanner(System.in);
		game.drawBoard();
		boolean flag = true;
		while(flag) {
			System.out.print("Where would you like to move? Enter row number followed by column number ");
			int selectedRow = scan.nextInt();
			int selectedCol = scan.nextInt();
			if((selectedRow > 0 && selectedRow <= 3) && (selectedCol > 0 && selectedCol <= 3)) {
				flag = false;
				int row = selectedRow;
				int col = selectedCol;
				int[] move_array = {row, col};
				Move my_move = new Move(move_array);
				return my_move;
			}
			else {
				System.out.println("Incorrect input. Try again.");
			}
		}
		// Draw the current game board for the human player


		// Collect input from the current player on what move the player wants to make

		// Create a Move object from the input provided by the human player

		// Return the Move object
		return null;
	}
}
