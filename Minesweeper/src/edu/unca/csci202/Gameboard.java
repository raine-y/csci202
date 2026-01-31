package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;

public class Gameboard {
	private final static int ROWS = 10;
	private final static int COLS = 10;
	private final static int NUMOFMINES = 10;
	protected Cell[][] board = new Cell[ROWS][COLS];

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int r, c; // selected r and column
		char m; // mine?

		// LABELING A MINE BLOWS IT UP STILL & PRINT RETURNS NOTHING

		board = fillBoard();
		printBoard(board);

		while (true) {
			while (true) {
				r = getUserInput(scanner, "Please enter row (1-8): ");
				if (r >= 1 && r <= 8)
					break;
				else {
					System.out.println("Try again: must be between 0 and 9.");
				}
			}
			while (true) {
				c = getUserInput(scanner, "Please enter column (1-8): ");
				if (c >= 1 && c <= 8) {
					break;
				} else {
					System.out.println("Try again: must be between 0 and 9.");
				}
			}
			while (true) {
				System.out.print("Is this cell a mine? (y/n): ");
				m = scanner.next().charAt(0);
				if (m == 'y' || m == 'Y') {
					board[r][c].setValue("M ");
				} else if (m == 'n' || m == 'N') {
					break;
				} else {
					System.out.println("Try again: must be y or n.");
					continue;
				}
				scanner.nextLine();
				break;
			}
			if (board[r][c].getMine() == true) {
				System.out.println("Boom! " + r + ", " + c + " was a mine.");
				break;
			} else if (board[r][c].getValue() == "M ") {

			} else {
				board[r][c].setValue(lookAround(r, c, board));
				board[r][c].setChecked(true);
			}

			printBoard(board);

			while (true) {
				System.out.print("Would you like to cheat? (y/n): ");
				c = scanner.next().charAt(0);
				if (c == 'y' || c == 'Y') {
					scanner.nextLine();
					peakAtBoard(board); // TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				} else if (c == 'n' || c == 'N') {
					break;
				} else {
					System.out.println("Try again: must be y or n.");
					continue;
				}
				scanner.nextLine();
				break;
			}
		}
		System.out.println("Game over!");
	} // END run()

	public Cell[][] fillBoard() {
		Random generator = new Random();
		for (int i = 0; i < ROWS; i++) { // sets edges as a border
			Cell cell = new Cell(true, true);
			board[0][i] = cell; // first row
			board[9][i] = cell; // last row
			board[i][0] = cell; // first column
			board[i][9] = cell; // last column
		}
		for (int r = 1; r < ROWS - 1; r++) { // sets
			for (int c = 1; c < COLS - 1; c++) {
				Cell cell = new Cell(false, false, false);
				board[r][c] = cell;
			}
		}
		for (int i = 0; i < NUMOFMINES; i++) {
			int r = generator.nextInt(8) + 1;
			int c = generator.nextInt(8) + 1;
			if (board[r][c].getMine() == false) {
				board[r][c].setMine(true);
			} else
				--i;
		}
		return board;
	} // END fillBoard()

	public static void printBoard(Cell[][] board) {
		for (int r = 1; r < ROWS - 1; r++) {
			for (int c = 1; c < COLS - 1; c++) {
				System.out.print(board[r][c]);
			}
			System.out.println("");
		}
	} // END printBoard()

	public static void peakAtBoard(Cell[][] board) {
		for (int r = 1; r < ROWS - 1; r++) {
			for (int c = 1; c < COLS - 1; c++) {
				System.out.print(board[r][c].getValue());
			}
			System.out.println("");
		}
	} // END peakAtBoard()

	public static String lookAround(int row, int col, Cell[][] board) {
		int mineCount = 0;
		for (int r = row - 1; r < row + 2; r++) {
			for (int c = col - 1; c < col + 2; c++) {
				if (board[r][c].getMine() == true)
					mineCount++;
			}
		}
		return String.valueOf(mineCount);
	} // END lookAround()

	private static int getUserInput(Scanner scanner, String msg) {
		while (true) {
			System.out.print(msg);
			String input = scanner.nextLine();
			try {
				int parsed = Integer.parseInt(input);
				return parsed;
			} catch (NumberFormatException e) {
				System.out.println("Try again; must be an integer.");
			}
		}
	} // END getUserInput()
}
