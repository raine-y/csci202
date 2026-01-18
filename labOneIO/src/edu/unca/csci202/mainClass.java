package edu.unca.csci202;

import java.util.Scanner;

public class mainClass {

	public static final int TOTAL_INPUTS = 10; // avoiding 'magic' numbs

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] input = new int[TOTAL_INPUTS];
		int correctNumbers = 0; // good reads & index
		// read in until 10 correct user inputs
		while (correctNumbers < TOTAL_INPUTS) {
			System.out.print("[" + (correctNumbers + 1) +"/10] Please enter an integer: ");
			try {
				input[correctNumbers] = Integer.parseInt(scanner.nextLine()); // Docs reveal NumberFormatException
				// user got it right
				correctNumbers ++;
			} catch (NumberFormatException e) {
				// user messed it up
				System.out.println("Not an integer, please try again.");
			} // end of try-catch
		}
		scanner.close();
		System.out.println("The average is " + average(input));
	} // end of main
	
	public static double average(int[] input) {
		double average;
		int total = 0;
		for (int i = 0; i < TOTAL_INPUTS; i++)
			total += input[i];
		average = total / 10.0; // floating point division
		return average;
		
	} // end of average
}