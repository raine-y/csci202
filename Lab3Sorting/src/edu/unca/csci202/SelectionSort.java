package edu.unca.csci202;

import java.util.Arrays;

public class SelectionSort extends SuperSort {
	public SelectionSort() {
		super();
	}

	@Override
	public void sort(int[] a, boolean debugMode) {
		for (int i = 0; i < a.length - 1; i++) {
			// find smallest value at index i
			int smallest = i;
			for (int j = i; j < a.length; j++) {
				this.numOfComparisions++;
				if (a[j] < a[smallest]) {
					smallest = j;
				}
			}
			// index smallest has the smallest value from i to the end

			// swap that smallest value into index i
			if (smallest != i) {
				int temp = a[smallest];
				a[smallest] = a[i];
				a[i] = temp;
				this.numOfMoves++;
				if (debugMode) {
					System.out.println("Swapped " + a[smallest] + " with " + a[i] + ".");
					System.out.println(Arrays.toString(a));
				}
			}

		}
	}
}
