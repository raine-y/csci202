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

		while (true) { // takes user inputs for number of files and number of data points for each file.
			Scanner scanner = new Scanner(System.in);
			try {
				System.out.print("Please enter the number of files to create: ");
				numFiles = scanner.nextInt();
				System.out.print("Please enter the number of data points in each file: ");
				numData = scanner.nextInt();
				scanner.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("That is not a number. Please try again.");
				scanner.nextLine(); // clears scanner buffer
				continue;
			}
		} // while loop ends

		DataFileFactory userFileRequest = new DataFileFactory(numFiles, numData);

		while (true) { // writes files and gives error rate
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
				Scanner scanner = new Scanner(file);
				for (int d = 0; d < numData; d++) {
					try {
						fileByData[f][d] = scanner.nextInt();
						System.out.print(fileByData[f][d]);
					} catch (InputMismatchException e) {
						try {
							fileByData[f][d] = Integer.parseInt(scanner.nextLine());
							System.out.print(fileByData[f][d]);
						} catch (NumberFormatException e2) {
							System.out.print(-1); // visually indicates garbage without recording value
						}
					}
					if (d < numData - 1) {
						System.out.print(", ");
					}
				}
				System.out.println("");
				scanner.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found." + e);
		} catch (IOException e) {
			System.out.println("IO failed or interrupted." + e);
		}

		System.out.println("#6 Sum of each column:");
		for (int f = 0; f < numFiles; f++) {
			int sum = 0;
			for (int d = 0; d < numData; d++) {
				sum += fileByData[f][d];
			}
			System.out.println("Column " + f + " has sum=" + sum);
		} // foor loop ends

		userFileRequest.removeFiles();
	}
}