public class Move {
	int[] move;
	String myString;

	public Move() {
		move = new int[2];
	}

	public Move(int[] move) {
		if(move.length == 2) {
			this.move = move;
		}
		else {
			throw new IllegalArgumentException("A move is a 1D array of two integers");
		}
	}

	public int[] getMove() {
		return this.move;
	}
}
