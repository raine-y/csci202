package edu.unca.csci202;

public class Minesweeper {
    public static final String WHITE_BOLD = "\033[1;37m"; // WHITE

	public static void main(String[] args) {

		Gameboard gameboard = new Gameboard();
		intro(); // thanks patorjk.com
		gameboard.run();
	}

	private static void intro() {
		System.out.println(" ___  ____                                                   \n"
				+ " |  \\/  (_)                      " + WHITE_BOLD +"welcome to..." + Gameboard.RESET + "                     \n"
				+ " | .  . |_ _ __   ___  _____      _____  ___ _ __   ___ _ __ \n"
				+ " | |\\/| | | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|\n"
				+ " | |  | | | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |   \n"
				+ " \\_|  |_/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|   \n"
				+ "                                            | |              \n"
				+ "                                            |_|              ");
	}
}