package edu.unca.csci202;

import java.util.Arrays;
import java.util.Scanner;

public class SortLab {
	public static void main(String[] args) {
		int mode; // validation or speed test
		int alg; // Bubble, selection or insertion
		int n = 0; // problem size in speed test
		Scanner scanner = new Scanner(System.in);
		// user input
		while (true) { // get mode
			mode = getUserInput(scanner, "Which test do you want to run: validation (1) or speed (2): ");
			if (mode == 1 || mode == 2)
				break;
			else {
				System.out.println("Try again: must be 1 or 2.");
			}
		}
		while (true) { // get sort type
			alg = getUserInput(scanner,
					"Which algorithm do you want to use: Bubble (1), Insertion (2), or Selection (3): ");
			if (alg == 1 || alg == 2 || alg == 3)
				break;
			else {
				System.out.println("Try again: must be 1, 2 or 3.");
			}
		}
		if (mode == 2) { // if in speed mode
			while (true) { // get n (problem size in speed test)
				n = getUserInput(scanner, "How many values do you want to sort (more than 1): ");
				if (n > 1)
					break;
				else {
					System.out.println("Try again: must be more than 1.");
				}
			}
		}
		// sorting tests
		SuperSort sorter;
		
		if (alg == 1)
			sorter = new BubbleSort();
		else if (alg == 2)
			sorter = new InsertionSort();
		else {
			sorter = new SelectionSort();
		}
		
		if (mode == 1) {
			// validation test
			int[] testData = makeTestNumbers();
			sorter.sort(testData, true);
			System.out.println(Arrays.toString(testData));
			sorter.printStats();
		} else if (mode == 2) {
			// speed test
			int[] testData = generateRandomNumbers(n);
			long startTime = System.currentTimeMillis();
			sorter.sort(testData, false);
			long endTime = System.currentTimeMillis();
			long timeElapsed = endTime - startTime;
			System.out.println("Time elapsed: " + timeElapsed + " milliseconds.");
			sorter.printStats();
		}
	}

	private static int getUserInput(Scanner scanner, String msg) { // helper method
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

	private static int[] makeTestNumbers() {
		int[] a = { 1, 7, 4, 2, 3, 5, 6, 9, 10000, 3 };
		return a;
	}
	
	private static int[] generateRandomNumbers(int n) {
		java.util.Random rand = new java.util.Random();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = rand.nextInt(1000);
		}
		return x;
	}
}