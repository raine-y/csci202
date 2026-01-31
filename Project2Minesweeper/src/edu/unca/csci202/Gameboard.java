package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;

public class Gameboard {
    public static final String YELLOW = "\033[0;33m"; // YELLOW
    public static final String WHITE_BOLD = "\033[1;37m"; // WHITE
    protected static final String RESET = "\033[0m"; // Text Reset
	private final static int ROWS = 10;
	private final static int COLS = 10;
	private final static int NUMOFMINES = 10;
	protected Cell[][] board = new Cell[ROWS][COLS];
	private static final int TOTALGUESSES = (ROWS - 2) * (COLS - 2);
	private static int correctGuessCount = 0;

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int r, c; // selected r and column

		board = setBoard();
		printBoard(board, false);

		while (true) {
			while (true) {
				r = getUserInt(scanner, "Please enter row (1-8): ");
				if (r >= 1 && r <= 8)
					break;
				else
					System.out.println("Try again: must be between 0 and 9.");
			}

			while (true) {
				c = getUserInt(scanner, "Please enter column (1-8): ");
				if (c >= 1 && c <= 8)
					break;
				else
					System.out.println("Try again: must be between 0 and 9.");
			}

			getUserFlag(scanner, "Is this cell a mine? (y/n): ", board[r][c]);

			if (board[r][c].getChecked() == false) {
				if (board[r][c].getFlagged() == true && board[r][c].getMine() != true) {
					System.out.println("Oops! " + r + ", " + c + " was not a mine.");
					break;
				} else if (board[r][c].getFlagged() == true) {
					correctGuessCount++;
					System.out.println(r + ", " + c + " is flagged");
				} else if (board[r][c].getMine() == true) {
					System.out.println("Boom! " + r + ", " + c + " was a mine.");
					break;
				} else {
					correctGuessCount++;
					board[r][c].setChecked(true);
					int total = countAdjacentMines(r, c, board);
					board[r][c].setValue(total);
				}
			} else {
				System.out.println("Cell " + r + ", " + c + " has already been checked");
			}

			if (correctGuessCount == TOTALGUESSES) {
				System.out.println("You won! Congratz.");
				break;
			}
			
			printBoard(board, false);
			
			getUserCheat(scanner, "Is you like to cheat? (y/n): ", board);
		}
		System.out.println("Game over.");
	}

	public Cell[][] setBoard() {
		Random generator = new Random();
		for (int i = 0; i < ROWS; i++) { // sets edges as a border
			Cell border = new Cell();
			board[0][i] = border; // first row
			board[9][i] = border; // last row
			board[i][0] = border; // first column
			board[i][9] = border; // last column
		}
		for (int r = 1; r < ROWS - 1; r++) { // sets gameboard cells as unchecked
			for (int c = 1; c < COLS - 1; c++) {
				Cell cell = new Cell(false, false);
				board[r][c] = cell;
			}
		}
		for (int i = 0; i < NUMOFMINES; i++) { // lays mines
			int r = generator.nextInt(8) + 1;
			int c = generator.nextInt(8) + 1;
			if (board[r][c].getMine() == false) {
				board[r][c].setMine(true);
			} else {
				--i;
			}
		}
		return board;
	} // END setBoard()

	public void printBoard(Cell[][] board, boolean cheat) {
		if (cheat) {
			for (int r = 1; r < ROWS - 1; r++) {
				for (int c = 1; c < COLS - 1; c++) {
					if (board[r][c].getMine() == true)
						System.out.print(YELLOW + "M " + RESET);
					else
						System.out.print(countAdjacentMines(r, c, board) + " ");	
				}
				System.out.println("");
			}
		} else {
			for (int r = 1; r < ROWS - 1; r++) {
				for (int c = 1; c < COLS - 1; c++) {
					System.out.print(board[r][c]);
				}
				System.out.println("");
			}
		}

	}

	private static int getUserInt(Scanner scanner, String msg) {
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

	private static void getUserFlag(Scanner scanner, String msg, Cell cell) {
		while (true) {
			System.out.print(msg);
			char input = scanner.next().charAt(0);
			if (input == 'y' || input == 'Y') {
				scanner.nextLine();
				cell.setFlagged(true);
				break;
			} else if (input == 'n' || input == 'N') {
				scanner.nextLine();
				break;
			} else
				System.out.println("Try again; must be either y or n.");
		}
	}
	
	private void getUserCheat(Scanner scanner, String msg, Cell[][] board) {
		while (true) {
			System.out.print(msg);
			char input = scanner.next().charAt(0);
			if (input == 'y' || input == 'Y') {
				scanner.nextLine();
				printBoard(board, true);
				break;
			} else if (input == 'n' || input == 'N') {
				scanner.nextLine();
				printBoard(board, false);
				break;
			} else
				System.out.println("Try again; must be either y or n.");
		}
	}

	private static int countAdjacentMines(int row, int col, Cell[][] board) {
		int mineCount = 0;
		for (int r = row - 1; r < row + 2; r++) {
			for (int c = col - 1; c < col + 2; c++) {
				if (board[r][c].getMine() == true)
					mineCount++;
			}
		}
		return mineCount;
	}
}
