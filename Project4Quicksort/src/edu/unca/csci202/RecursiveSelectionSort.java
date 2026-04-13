package edu.unca.csci202;

public class RecursiveSelectionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

	public RecursiveSelectionSort() {
		super();
	}

	public RecursiveSelectionSort(boolean debug) {
		super(debug);
	}

	@Override
	public void sort() {
		sortHelper(head);
	}

	private void sortHelper(Node<T> startNode) {
	    if (startNode == null || startNode.next == null) {
	        return;
	    }

	    Node<T> curr = startNode;
	    Node<T> min = startNode;
	    while (curr != null) {
	        numberOfComparisons++;
	        if (curr.data.compareTo(min.data) < 0) {
	            min = curr;
	        }
	        curr = curr.next;
	    }

	    if (startNode.data.compareTo(min.data) != 0) {
	        swap(startNode, min);
	    }

	    sortHelper(startNode.next);
	}
}
