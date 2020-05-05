/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author trishatolentino
 */
public class Ttt2 {

    /**
     * @param args the command line arguments
     */
    static Scanner in;
    static String[] board;
    static String turn;
    static String user;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;
                String user = "Player 1";
//                welcomePrompt();

            //game start menu + instructions
            welcomePrompt();
            //print numbers first before printing board to prevent null on first display!
            printBoardNumbers();
            printBoard();
            startGamePrompt();
//            humanChoose();
//            checkNumber();
//            checkWinner();
            

		while (winner == null) {
			int numInput;
                        numInput = in.nextInt();
                        if (!(numInput > 0 && numInput <= 9)) {
                                System.out.println("Please enter a valid number between 1-9:");
                                continue;
                        }
                        //mark spot with turn then switch player
			if (board[numInput-1].equals(String.valueOf(numInput))) {
				board[numInput-1] = turn;
                                if (turn == "X") {
//				if (turn.equals("X")) {
					turn = "O";
				} else {
					turn = "X";
				}
				printBoard();
				winner = checkWinner();
			} else {
				System.out.println("This spot has already been taken! Please choose another number:");
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("Tie game/Draw! Game over.");
		} else {
			System.out.println("Congrats, " + winner + " is the winner!! Thanks for playing.");
		}
	}

        //winning combinations
	public static String checkWinner() {
		for (int i = 0; i < 8; i++) {
			String line = null;
			switch (i) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
                        //declare winner if line is fully marked and matches either XXX or OOO
			if (line.equalsIgnoreCase("XXX")) {
				return "Player 1";
			} else if (line.equalsIgnoreCase("OOO")) {
				return "Player 2";
			}
		}
		for (int i = 0; i < 9; i++) {
			if (Arrays.asList(board).contains(String.valueOf(i+1))) {
				break;
			}
			else if (i == 8) {
                            return "draw";
                        }
		}
                //prompt to continue to play game if open spots available with no winner or draw
                if (turn == "O") {
                    user = "Player 2";
                } else {
                    user = "Player 1";
                }     
		System.out.println(user + "'s turn! Please enter a spot number to mark " + turn + " into:");
		return null;
	}
        
        public static void welcomePrompt() {
            System.out.println("Welcome to Totally Human TicTacToe!");
            System.out.println("");
            System.out.println("Please choose an open spot on the gameboard below.");
            System.out.println("");
            System.out.println("The first player to match 3 spots in a row wins!");
            System.out.println("");
            System.out.println("Player 1 = X // Player 2 = O");
            System.out.println("");
            System.out.println("--------------------------------");
            System.out.println("");
        }

	public static void printBoardNumbers() {
            //array starts at 0, so print value +1 to display 1-9
		for (int i = 0; i < 9; i++) {
			board[i] = String.valueOf(i+1);
		}
	}
	public static void printBoard() {
                System.out.println("");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
                System.out.println("");
	}
        
        public static void startGamePrompt() { 
            System.out.println("");
            System.out.println("--------------------------------");
            System.out.println("Player 1, please begin the game by choosing the first spot number to mark " 
                    + turn + " into: ");
        }
}
    