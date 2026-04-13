package edu.unca.csci202;

public class BubbleSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

	public BubbleSort() {
		super();
	}

	public BubbleSort(boolean debug) {
		super(debug);
	}

	@Override
	public void sort() {
		boolean swapped;

		do {
			Node<T> traverseNode = head;
			swapped = false;
			while (traverseNode.next != null) {
				Node<T> tempNext = traverseNode.next;
				numberOfComparisons++;
				if (traverseNode.data.compareTo(tempNext.data) > 0) {
					swapped = true;
					swap(traverseNode, tempNext);
				}
				traverseNode = traverseNode.next;
			}
		} while (swapped);
	}
}
