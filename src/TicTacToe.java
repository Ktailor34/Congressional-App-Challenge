/**
 * Created by s738110 on 9/3/16.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe implements Game {

	Random generator = new Random();
	public int[][] board;
	private int[][] playerBoard;
	private int[][] computerBoard;
	private int[][][] winConditions;
	private Player activePlayer;
	private Player inactivePlayer;
	public final int SIZE = 3;
    private int gameCount;

	// Constructor
	public TicTacToe(Player p1, Player p2) {
	    gameCount = 0;
		board = new int[SIZE][SIZE];
		playerBoard = new int[SIZE][SIZE];
		computerBoard = new int[SIZE][SIZE];

		for(int r = 0; r < SIZE; r++) {
			for(int c = 0; c < SIZE; c++) {
				board[r][c] = 0;
				playerBoard[r][c] = 0;
				computerBoard[r][c] = 0;
			}
		}

		winConditions = new int[][][] {
		    {
		        {1,1,1},
                {0,0,0},
                {0,0,0}
            },
            {
                {0,0,0},
                {1,1,1},
                {0,0,0}
            },
            {
                {0,0,0},
                {0,0,0},
                {1,1,1}
            },
            {
                {1,0,0},
                {1,0,0},
                {1,0,0}
            },
            {
                {0,1,0},
                {0,1,0},
                {0,1,0}
            },
            {
                {0,0,1},
                {0,0,1},
                {0,0,1}
            },
            {
                {1,0,0},
                {0,1,0},
                {0,0,1}
            },
            {
                {0,0,1},
                {0,1,0},
                {1,0,0}
            }
        };
	}

	public void drawBoard() {
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				System.out.print(board[r][c] + " ");
				if (c  == 2) {
					System.out.println();
				}
			}
		}
	}

	public void playerMove() {

	 }

	public void computerMove() {
		int compPlacement = generator.nextInt(9);
		boolean moveMade = false;

		while (moveMade != true){
			if (board[compPlacement/3][compPlacement%3] == 0 ) {
				board[compPlacement/3][compPlacement%3] = 2;
                computerBoard[compPlacement/3][compPlacement%3] = 1;
				moveMade = true;
			} else {
				compPlacement = generator.nextInt(9);
			} // end of if
		} // end of while
	}

	private boolean gameOver() {
		int[][] result = new int[3][3];

		for (int k = 0; k < 8; k++) {
			int r, c;
			int[][] winBoard = winConditions[k];

			for (int[] row : result) {
				Arrays.fill(row, 0);
			}
			for (r = 0; r < playerBoard.length; r++) {
				for (c = 0; c < playerBoard[r].length; c++) {
					result[r][c] = playerBoard[r][c] & winBoard[r][c];
					if (Arrays.deepEquals(result, winBoard)) {
						System.out.println("Player Wins!");
						return true;
					}
				}
			}

			for (int[] row : result) {
				Arrays.fill(row, 0);
			}
			for (r = 0; r < computerBoard.length; r++) {
				for (c = 0; c < computerBoard[r].length; c++) {
					result[r][c] = computerBoard[r][c] & winBoard[r][c];
					if (Arrays.deepEquals(result, winBoard)) {
						System.out.println("Computer Wins!");
						return true;
					}
				}
			}
		}

		if (gameCount == 9) return true;
		gameCount++;
		return false;
	}

    @Override
    public void applyMove(Move move) {

    }

    @Override
    public Game forecastMove(Move move) {
        return null;
    }

    @Override
    public Game copy() {
        return null;
    }

    @Override
    public List<Move> getLegalMoves() {
        return null;
    }

    @Override
    public List<Move> getOpponentMoves() {
        return null;
    }

    @Override
    public boolean isWinner(Player player) {
        return false;
    }

    @Override
    public boolean isOpponentWinner(Player player) {
        return false;
    }

    public Player getInactivePlayer() {
        return inactivePlayer;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }
}

