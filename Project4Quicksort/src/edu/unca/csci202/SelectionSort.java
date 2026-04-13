package edu.unca.csci202;

public class SelectionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

	public SelectionSort() {
		super();
	}

	public SelectionSort(boolean debug) {
		super(debug);
	}

	@Override
	public void sort() {
		for (Node<T> start = head; start != null; start = start.next) {
			Node<T> min = start;
			for (Node<T> curr = start.next; curr != null; curr = curr.next) {
				this.numberOfComparisons++;
				if (curr.data.compareTo(min.data) < 0) {
					min = curr;
				}
			}
			if (min != start)
				swap(min, start);
		}
	}

}
