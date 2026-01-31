package edu.unca.csci202;

import java.util.Arrays;

public class BubbleSort extends SuperSort {
	public BubbleSort() {
		super();
	}

	@Override
	public void sort(int[] a, boolean debugMode) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				this.numOfComparisions++;
				if (a[j] > a[j + 1]) {
					int temp = a[j]; // swappin'
					a[j] = a[j + 1];
					a[j + 1] = temp;
					this.numOfMoves++;
					if (debugMode) {
						System.out.println("Swapped " + a[j] + " with " + a[j + 1] + ".");
						System.out.println(Arrays.toString(a));
					}
				}
			}
		}
	}

}
