package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * The logic of the Minesweeper game.
 */
public class Gameboard {
	protected static final String YELLOW = "\033[0;33m";
	protected static final String WHITE_BOLD = "\033[1;37m"; 
	protected static final String RESET = "\033[0m"; 

	private final static int ROWS = 10;
	private final static int COLS = 10;
	private final static int NUMOFMINES = 10;
	private final static int TOTALSAFECELLS = 64 - NUMOFMINES;

	protected Cell[][] board = new Cell[ROWS][COLS];
	private int correctGuessCount = 0;

	/**
	 * Called by Minesweeper.java, sets the board, gets if the user would like to cheat, which column and row
	 * the user is guessing, if their guess is a mine and then either loops if the user guessed safely, ends if
	 * the user guessed a mine without flagging it, or ends if the user won.
	 */
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int r, c;

		board = setBoard();
		printBoard(board, false);

		while (true) {
			getUserCheat(scanner, "Would you like to cheat? (y/n): ", board);
				
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

			if (board[r][c].getFlagged()) {
			    System.out.println(r + ", " + c + " is flagged");
			} else if (board[r][c].getChecked()) {
			    System.out.println("Cell " + r + ", " + c + " has already been checked");
			} else if (board[r][c].getMine()) {
			    System.out.println("Boom! " + r + ", " + c + " was a mine.");
			    break;
			} else {
			    expand(r, c);
			}																			 

			if (correctGuessCount == TOTALSAFECELLS) {
				printBoard(board, false);
				System.out.println("You won! Congratz.");
				break;
			}

			printBoard(board, false);

		}
		System.out.println("Game over.");
	}

	/**
	 * Takes the initialized 2D array "board", sets borders, marks the remaining Cells as 
	 * uncheled and then randomly places 10 mines
	 * @return Returns a ready to play 2D array of Cells.
	 */
	private Cell[][] setBoard() {
		Random generator = new Random();
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1) {
					board[r][c] = new Cell();
				} else {
					board[r][c] = new Cell(false, false);
				}
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
	} 

	/**
	 * Takes the current board and a boolean representing if the user would like to peak
	 * and then prints the board based on the user input.
	 * @param board Current board.
	 * @param cheat Boolean true if the user would like to "peek" at the board in-between rounds.
	 */
	public void printBoard(Cell[][] board, boolean cheat) {
		if (cheat) {
			for (int r = 1; r < ROWS - 1; r++) {
				for (int c = 1; c < COLS - 1; c++) {
					if (board[r][c].getMine())
						System.out.print(YELLOW + "M " + RESET);
					else if (board[r][c].getChecked())
						System.out.print(board[r][c]);
					else
						System.out.print("- ");
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
	
	/**
	 * Gets a user input and makes sure it is an integer, used when getting user input of the
	 * row & the column for guess. 
	 * @param scanner Takes user inputs of an integer & handles errors if another char is entered.
	 * @param msg Takes prewritten "row / column" message.
	 * @return Returns user integer.
	 */
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
	} 
	
	/**
	 * Checks if the user would like to flag the selected Cell as a mine.
	 * @param scanner Takes user inputs of y or n & handles errors if another char is entered.
	 * @param msg Takes prewritten "is this cell a mine?" message.
	 * @param cell The Cell that the user selected.
	 */
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

	/**
	 * Checks if the user would like to "peek" at the board in-between rounds.
	 * @param scanner Takes user inputs of y or n & handles errors if another char is entered.
	 * @param msg Takes prewritten "would you like to cheat?" message.
	 * @param board Takes the current gameboard to either display the standard unchecked board
	 * or the location of every mine.
	 */
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
	
	/**
	 * Looks at the Cells immediatly around the given Cell and incriments a counter for every mine found.
	 * @param row The user input for the Cell row.
	 * @param col The user input for the Cell column.
	 * @param board Takes the current gameboard to search around the user input Cell.
	 * @return
	 */
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

	/**
	 * Adds a non-mine Cell to the stack and checks the surroundings for mines and checked Cells, adding them 
	 * to the stack if they are not and then pushes it to the stack until no sourrounding "safe Cells" remain. 
	 * @param row The user input for the Cell row.
	 * @param col The user input for the Cell column.
	 */
	private void expand(int row, int col) {
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { row, col });
		while (!stack.isEmpty()) {
			int[] pos = stack.pop(); // 2 long int array of row & column pop'd out of stack and consumed
			int r = pos[0];
			int c = pos[1];
			if (r < 1 || r > 8 || c < 1 || c > 8) // Ignores borders
				continue;
			Cell current = board[r][c];
			if (current.getChecked() || current.getFlagged() || current.getMine())
				continue;
			current.setChecked(true);
			correctGuessCount++;
			int adjMines = countAdjacentMines(r, c, board);
			current.setValue(adjMines);
			
			if (adjMines == 0) { // pushes adjacent 0s to the stack to keep it goin'
				for (int i = r - 1; i <= r + 1; i++) {
					for (int j = c - 1; j <= c + 1; j++) {
						stack.push(new int[] { i, j });
					}
				}
			}
		}
	}

}
