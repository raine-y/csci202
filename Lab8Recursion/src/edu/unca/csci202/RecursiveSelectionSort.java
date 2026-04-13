package edu.unca.csci202;

public class RecursiveSelectionSort<T extends Comparable<T>> {

	@SuppressWarnings("hiding")
	private class Node<T> {
		Node<T> next;
		T element;
	}

	private int count;
	private boolean debugMode;
	private Node<T> head, tail;

	/**
	 * Construct a new sort-able list when debugMode is true.
	 * 
	 * @param debugMode when true, print every swap. when false, print nothing.
	 */
	public RecursiveSelectionSort(boolean debugMode) {
		this.debugMode = debugMode;
		head = tail = null;
		count = 0;
	}

	/**
	 * Construct a list with debugMode off. It will not print any swaps.
	 */
	public RecursiveSelectionSort() {
		this(false);
	}

	/**
	 * Put the element parameter into the back of the list.
	 * 
	 * @param element the element to put in the back of the list.
	 */
	public void addToBack(T element) {
		Node<T> newNode = new Node<T>();
		newNode.element = element;

		if (count == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		count++;
	}

	/**
	 * Sort the list using a recursive selection sort algorithm.
	 */
	public void sort() {
		sortHelper(head);
	}

	/**
	 * Recursive selection sort algorithm. Sorting the list from startNode to tail.
	 * @param startNode The first node to be sorted.
	 */
	private void sortHelper(Node<T> startNode) {

		if (startNode == null || startNode == tail) {
			return;
		}

		Node<T> curr = startNode;
		Node<T> min = startNode;
		while (curr != null) {
			this.count++;
			if (curr.element.compareTo(min.element) < 0) {
				min = curr;
			}
			curr = curr.next;
		}

		if (startNode.element.compareTo(min.element) != 0) {
			T temp = startNode.element;
			startNode.element = min.element;
			min.element = temp;
			
			if (debugMode == true) {
				System.out.println(this);
			}
		}
		
		sortHelper(startNode.next);
	}

	@Override
	public String toString() {
		String s = "[";
		Node<T> curr = head;
		
		while (curr != null) {
			if (curr.next != null) {
				s += curr.element + " ";
				curr = curr.next;
			} else {
				s += curr.element;
				curr = curr.next;
			}
		}
		
		s += "]";
		return s;
	}
}
