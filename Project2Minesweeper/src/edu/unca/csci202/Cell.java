package edu.unca.csci202;

public class Cell {
	private int value;
	private boolean checked, mine, flagged;
	
	public Cell() {
		
	}
	public Cell(boolean checked, boolean mine) {
		
	}
	
	// getters
	
	public boolean getMine() {
		return mine;
	}
	
	public boolean getChecked() {
		return checked;
	}
	
	public boolean getFlagged() {
		return flagged;
	}
	public int getValue() {
		return value;
	}
	
	// setter
	
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	// toString
	
	public String toString() { 
		if (flagged == true && mine == true) {
			return Gameboard.YELLOW + "M " + Gameboard.RESET;
		} else if (checked == false) {
			return "- ";
		} else if (checked == true) {
			return String.valueOf(value) + " ";
		} else {
			return "e ";
		}
	}

}
