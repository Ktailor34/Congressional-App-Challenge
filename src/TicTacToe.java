/**
 * Created by s738110 on 9/3/16.
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
	Scanner scan = new Scanner(System.in);
	Random generator = new Random();
	private int[][] board;
	private int[][] playerBoard;
	private int[][] computerBoard;
	private int[][][] winConditions;
	private final int SIZE = 3;
    boolean finish = false;


	// Constructor
	public TicTacToe() {
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

	private void playerMove() {
		boolean flag = true;
		while(flag) {
			System.out.print("Pick spots 1 - 9: ");
			int selection = scan.nextInt();
			if(selection > 0 && selection <=9) {
				flag = false;
				board[(selection - 1)/3][(selection - 1) % 3] = 1;
				playerBoard[(selection -1)/3][(selection - 1) % 3] = 1;
			}
			else {
				System.out.println("Incorrect input. Try again.");
			}
		}
	}

	private void computerMove() {
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

	    for (int k = 0; k < 7; k++) {
            int[][] winBoard = winConditions[k];

            // Check winBoards
            /*for (int r = 0; r < SIZE; r++) {
                for (int c = 0; c < SIZE; c++) {
                    System.out.print(winBoard[r][c] + " ");
                    if (c  == 2) {
                        System.out.println();
                    }
                }
            }*/

            for(int[] row : result) {
                Arrays.fill(row, 0);
            }
            for (int i = 0; i < playerBoard.length; i++) {
                for (int j = 0; j < playerBoard[i].length; j++) {
                    result[i][j] = playerBoard[i][j] & winBoard[i][j];
                    if (Arrays.deepEquals(result, winBoard)) {
                        System.out.println("Player Wins!");
                        return true;
                    }
                }
            }

            for(int[] row: result) {
                Arrays.fill(row, 0);
            }
            for (int i = 0; i < computerBoard.length; i++) {
                for (int j = 0; j < computerBoard[i].length; j++) {
                    result[i][j] = computerBoard[i][j] & winBoard[i][j];
                    if (Arrays.deepEquals(result, winBoard)) {
                        System.out.println("Computer Wins!");
                        return true;
                    }
                }
            }
        }
        return false;
	}


	public void play() {
		while(!gameOver()) {
			drawBoard();
			playerMove();
			computerMove();
		}
	}

	public static void main(String args[]) {
		TicTacToe myGame = new TicTacToe();
		myGame.play();
	}
}

