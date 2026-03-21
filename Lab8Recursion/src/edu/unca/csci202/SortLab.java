package edu.unca.csci202;

import java.util.Random;

public class SortLab {
	public static void main(String[] args) {
        System.out.println("Validation Test:");
        RecursiveSelectionSort<Integer> validationList = new RecursiveSelectionSort<>(true);
        makeTestNumbers(validationList);
        System.out.println("Before: " + validationList);
        validationList.sort();
        System.out.println("After: " + validationList);
        
        System.out.println();

        System.out.println("Speed Test:");
        speedTest(100);
        speedTest(1000);
        speedTest(10000);
    }
	
	private static void speedTest(int size) {
        RecursiveSelectionSort<Integer> speedList = new RecursiveSelectionSort<>(false);
        generateRandomNumbers(speedList, size);

        long startTime = System.currentTimeMillis();
        speedList.sort();
        long endTime = System.currentTimeMillis();

        System.out.println("Size " + size + ": " + (endTime - startTime) + " ms");
    }
	
	private static void makeTestNumbers(RecursiveSelectionSort<Integer> list) {
        int[] arr = {90, 8, 7, 56, 123, 235, 2,  9, 1, 653};
        for (int i = 0; i < arr.length; i++) {
        	int num = arr[i];
            list.addToBack(num);
        }
    }

	private static void generateRandomNumbers(RecursiveSelectionSort<Integer> list, int count) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            list.addToBack(rand.nextInt(1000));
        }
    }
}
