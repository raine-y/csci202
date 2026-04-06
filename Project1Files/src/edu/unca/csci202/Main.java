package edu.unca.csci202;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

public class Main {

	private static final double ERROR_RATE = 0.25;

	public static void main(String[] args) {

		int numFiles, numData;

		while (true) { // takes user inputs for number of files and number of data points for each
						// file.
			Scanner scanner = new Scanner(System.in);
			try {
				System.out.print("Please enter the number of files to create: ");
				numFiles = scanner.nextInt();
				System.out.print("Please enter the number of data points in each file: ");
				numData = scanner.nextInt();
				scanner.close(); // avoid leakage
				break;
			} catch (InputMismatchException e) {
				System.out.println("That is not a number. Please try again.");
				scanner.nextLine(); // clears scanner buffer
				continue;
			}
		} // while loop ends

		DataFileFactory userFileRequest = new DataFileFactory(numFiles, numData);

		while (true) { 
			try {
				userFileRequest.writeFiles(ERROR_RATE);
				break;
			} catch (IOException e) {
				System.out.println("IO failed or interrupted.");
				continue;
			}
		} // while loop ends

		int fileByData[][] = new int[numFiles][numData];

		System.out.println("#5 printing array:");
		try {
			for (int f = 0; f < numFiles; f++) {
				File file = new File(userFileRequest.getFileName(f));
				try (Scanner fileScanner = new Scanner(file)) {
					int d = 0;
					while (d < numData && fileScanner.hasNext() == true) {
						if (fileScanner.hasNextInt() == true) {
							fileByData[f][d] = fileScanner.nextInt();
							System.out.print(fileByData[f][d]);
							if (d < numData - 1)
								System.out.print(", ");
							d++; // Increment to next index if good string
						} else {
							fileScanner.next(); // SKIPPING bad string
						}
					}
					System.out.println(); 
				} catch (FileNotFoundException e) {
					System.out.println("File not found: " + e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found." + e);
		} catch (IOException e) {
			System.out.println("IO failed or interrupted." + e);
		}

		for (int d = 0; d < numData; d++) {
			int colSum = 0;
			for (int f = 0; f < numFiles; f++) {
				colSum += fileByData[f][d];
			}
			System.out.println("Column " + d + " has sum=" + colSum);
		} // for loop ends

		userFileRequest.removeFiles();
	}
}