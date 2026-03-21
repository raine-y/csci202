package edu.unca.csci202;

import java.util.Scanner;

/**
 * The frontend of the Minesweeper program.
 */
public class Minesweeper {
	/**
	 * Introduction to the program that creates an instance of the gameboard class, calls Gameboard.java for game logic
	 * & checks if the user wants to keep playing after a game ends.
	 * @param args Takes command-line inputs.
	 */
	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			Gameboard gameboard = new Gameboard();
			intro();
			gameboard.run();
			boolean keepPlaying = getUserContinue(scanner, "Would you like to play again? (y/n): ");
			if (keepPlaying)
				continue;
			else
				break;
		}
	}
	
	/**
	 * Displays introductory header,
	 * ascii credit: patorjk.com
	 */
	private static void intro() {
		System.out.println(" ___  ____                                                   \n"
				+ " |  \\/  (_)                      " + Gameboard.WHITE_BOLD + "welcome to..." + Gameboard.RESET
				+ "                     \n" + " | .  . |_ _ __   ___  _____      _____  ___ _ __   ___ _ __ \n"
				+ " | |\\/| | | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|\n"
				+ " | |  | | | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |   \n"
				+ " \\_|  |_/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|   \n"
				+ "                                            | |              \n"
				+ "                                            |_|              ");
	}
	
	/**
	 * Checks if the user would like to play again after the conclusion of a game.
	 * @param scanner Takes user inputs of y or n & handles errors if another char is entered.
	 * @param msg Takes prewritten "would you like to continue?" message.
	 * @return Returns a boolean true if the user would like to keep playing (entered y or Y).
	 */
	private static boolean getUserContinue(Scanner scanner, String msg) {
		while (true) {
			System.out.print(msg);
			char input = scanner.next().charAt(0);
			if (input == 'y' || input == 'Y') {
				scanner.nextLine();
				return true;
			} else if (input == 'n' || input == 'N') {
				scanner.nextLine();
				return false;
			} else
				System.out.println("Try again; must be either y or n.");
			continue;
		}
	}
}