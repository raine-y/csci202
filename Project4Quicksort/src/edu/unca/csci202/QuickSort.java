package edu.unca.csci202;

public class QuickSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

	public QuickSort() {
		super();
	}

	public QuickSort(boolean debug) {
		super(debug);
	}

	@Override
	public void sort() {
		quicksort(head, tail);
	}

	private void quicksort(Node<T> min, Node<T> max) {
		if (min == null || max == null || min == max || max.next == min)
			return;
		Node<T> pivot = partition(min, max);
		if (pivot != null && pivot != min)
			quicksort(min, pivot.prev);
		if (pivot != null && pivot != max)
			quicksort(pivot.next, max);
	}

	private Node<T> partition(Node<T> min, Node<T> max) {
		if (min == null || max == null)
			return min;
		Node<T> pre = min;
	    Node<T> curr = min;
	    T pivotData = max.data; // use max as pivot

	    while (curr != max) {
	        numberOfComparisons++;
	        if (curr.data.compareTo(pivotData) < 0) {
	            swap(pre, curr);
	            pre = pre.next;
	        }
	        curr = curr.next;
	    }
	    swap(pre, max);
	    return pre;
	}
}
