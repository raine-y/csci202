package edu.unca.csci202;

public class Main {
	public static void main(String[] args) {
		System.out.println(recursiveIntegerAddition(3, 7));
		System.out.println(recursiveStringReverse("Hello, world!"));
	}
	
	public static int recursiveIntegerAddition(int i, int j) {
		if (j == 0)
			return 0;
		else return i + recursiveIntegerAddition(i, j - 1);
	}
	
	public static String recursiveStringReverse(String string) {
		if (string.length() <= 1)
			return string;
		else return recursiveStringReverse(string.substring(1)) + string.charAt(0);
	}
}