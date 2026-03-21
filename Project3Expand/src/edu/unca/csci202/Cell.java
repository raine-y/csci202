package edu.unca.csci202;

/**
 *  The Cell class represents an individual square in the Minesweeper grid & stores the values:
 *  value (number of surrounding mines),
 *  checked (boolean true if Cell has been guessed),
 *  mine (boolean true if Cell is a mine), &
 *  flagged (boolean true if user has identified the cell as a mine)
 */
public class Cell {
	private int value;
	private boolean checked, mine, flagged;

	/**
	 * Default constructor for a Cell representing a border (to prevent OutOfBoundsExceptions).
	 */
	public Cell() { 
	}

	/**
	 * Constructor for a cell in-play that contains checked & mine values.
	 * @param checked Boolean true if Cell has been guessed.
	 * @param mine Boolean true if Cell is a mine.
	 */
	public Cell(boolean checked, boolean mine) {
		this.checked = checked;
	    this.mine = mine;
	}

	// getters
	/**
	 * Getter method that returns boolean mine.
	 * @return Returns boolean true if Cell is a mine.
	 */
	public boolean getMine() {
		return mine;
	}
	/**
	 * Getter method that returns boolean checked.
	 * @return Returns boolean true if Cell has been guessed.
	 */
	public boolean getChecked() {
		return checked;
	}
	/**
	 * Getter method that returns boolean flagged.
	 * @return Returns boolean true if user has identified the cell as a mine.
	 */
	public boolean getFlagged() {
		return flagged;
	}
	/**
	 * Getter method that returns the number of adjacent mines found in Minesweeper.java's 
	 * countAdjacentMines(int row, int col, Cell[][] board) method as the variable "value."
	 * @return Returns number of surrounding mines.
	 */
	public int getValue() {
		return value;
	}

	// setter
	/**
	 * Setter method that sets the boolean mine. 
	 * @param mine Sets boolean true if Cell is a mine.
	 */
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	/**
	 * Setter method that sets the boolean flagged.
	 * @param flagged Sets boolean true if user has identified the cell as a mine.
	 */
	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}
	/**
	 * Setter method that sets the boolean checked.
	 * @param checked Sets boolean true if Cell has been guessed. 
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	/**
	 * Setter method that sets the number of adjacent mines found in Minesweeper.java's 
	 * countAdjacentMines(int row, int col, Cell[][] board) method as the variable "value."
	 * @param value Sets number of surrounding mines.
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * toString override that prints the current value of the Cell when the user is not "cheating."
	 */
	public String toString() {
		if (flagged && mine)
			return Gameboard.YELLOW + "M " + Gameboard.RESET;
		else if (checked)
			return String.valueOf(value) + " ";
		else
			return "- ";
	}

}
