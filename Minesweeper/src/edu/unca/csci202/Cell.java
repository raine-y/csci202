package edu.unca.csci202;

public class Cell {
	boolean checked, border, mine;
	String value;

	// constructors
	public Cell(boolean checked, boolean border) {
		this.checked = checked;
		this.border = border;
	}

	public Cell(boolean checked, boolean border, boolean mine) {
		this.checked = checked;
		this.border = border;
		this.mine = mine;
	}

	// getter
	public boolean getMine() {
		return mine;
	}

	public String getValue() {
		return value;
	}

	// setter
	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String toString() {

		switch (value) {
		case "mine":
			System.out.println();
		}

		if (border == true)
			return "";
		else if (value == "M ")
			return value;
		else if (checked == false)
			return "- ";
		else if (checked == true || mine == false)
			/* look around */
			return String.valueOf(value + " ");
		else
			return "M ";
	}

	public String toCheat() {
		if (border == true)
			return "";
		else if (mine == true)
			return "M ";
		else
			return toString();
	}
}