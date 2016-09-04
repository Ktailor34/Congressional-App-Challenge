/**
 * Created by s738110 on 9/3/16.
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    Scanner scan = new Scanner(System.in);
    Random generator = new Random();
    private int [][] board;
    private final int SIZE = 3;


    public TicTacToe() {
        board = new int[SIZE][SIZE];

        for(int r = 0; r < SIZE; r++) {
            for(int c = 0; c < SIZE; c++) {
                board[r][c] = 0;
            }
        }
    }

    public void drawBoard() {
            for (int r = 0; r < SIZE; r++) {
                for (int c = 0; c < SIZE; c++) {
                    System.out.print(board[r][c] + " ");
                    if (c  == 2 && r < 2) {
                        System.out.println();
                    }
                }
            }
        }

    private void player_move() {

    }

    private void computerMove() {
    	int compPlacement = generator.nextInt(10);
    	boolean moveMade = false;
    	
    	while (moveMade != true){
    		if (board[(compPlacement)/3][(compPlacement) % 3] == 0 ) {
    			board[(compPlacement)/3][(compPlacement) % 3] = 2;
    			moveMade = true;
    		} else {
    			compPlacement = generator.nextInt(10);
    		} // end of if
    	} // end of while
    }

    public void play() {
         System.out.print(" \n Pick spots 1 - 9: ");
        int selection = scan.nextInt();
        board[(selection - 1)/3][(selection - 1) % 3] = 1;
    }

	public static void main(String args[]) {
        TicTacToe myGame = new TicTacToe();
        boolean done = false;

        while (done != true){
        	myGame.drawBoard();
        	myGame.play();
            myGame.computerMove();
            
        }
    }
}
