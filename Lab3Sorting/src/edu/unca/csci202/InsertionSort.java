package edu.unca.csci202;

import java.util.Arrays;

public class InsertionSort extends SuperSort {
	public InsertionSort() {
		super();
	}

	@Override
	public void sort(int[] a, boolean debugMode) {
		for (int i = 0; i < a.length; ++i) {
			int k = a[i];
			int j = i - 1;
			this.numOfComparisions++;
			while (j >= 0 && a[j] > k) {
				a[j + 1] = a[j];
				j = j - 1;
				this.numOfMoves++;
				if (debugMode) {
					System.out.println("Swapped " + a[j + 1] + " with " + a[j] + ".");
					System.out.println(Arrays.toString(a));
				}
			}
			a[j+1] = k;
		}
	}

}
