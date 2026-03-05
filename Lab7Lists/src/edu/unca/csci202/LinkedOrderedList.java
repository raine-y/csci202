package edu.unca.csci202;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedOrderedList<T extends Comparable<T>> implements OrderedListADT<T> {
	// inner class for a Node. singly linked list node
	@SuppressWarnings("hiding")
	private class Node<T> {
		private Node<T> next;
		private T element;
	}

	// list data fields
	private Node<T> head;
	private int count;

	// constructor
	/**
	 * create an empty list
	 */
	public LinkedOrderedList() {
		count = 0;
		head = null;
	}

	@Override
	public T removeFirst() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("LinkedOrderedList is empty.");

		T temp = head.element;
		head = head.next;
		count--;

		return temp;
	}

	@Override
	public T removeLast() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("LinkedOrderedList is empty.");
		else if (size() == 1)
			return removeFirst();
		else { // list is size 2+...
			Node<T> curr = head, trail = null; // trail~ing pointer
			while (curr.next != null) {
				trail = curr;
				curr = curr.next;
			}

			trail.next = null;
			count--;
			return curr.element;
		}
	}

	@Override
	public T remove(T element) throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("could not find element: " + element);
		else if (size() == 1) {
			if (head.element.compareTo(element) == 0)
				return removeFirst();
			else
				throw new NoSuchElementException("could not find element: " + element);
		} else {
			Node<T> curr = head, trail = null;
			while (curr != null && curr.element.compareTo(element) != 0) {
				trail = curr;
				curr = curr.next;
			}

			if (curr == null)
				throw new NoSuchElementException("could not find element: " + element);
			else if (curr == head) {
				return removeFirst();
			} else {
				trail.next = curr.next;
				count--;
				return curr.element;
			}
		}
	}

	@Override
	public T first() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("No match found.");
		return head.element;
	}

	@Override
	public T last() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("No match found.");
		else {
			Node<T> curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}

			return curr.element;
		}
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@SuppressWarnings("hiding")
	private class LOLIterator<T> implements Iterator<T> {
		private Node<T> curr;

		public LOLIterator(Node<T> node) {
			curr = node;
		}

		@Override
		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public T next() {
			T temp = curr.element;
			curr = curr.next;
			return temp;
		}
	}

	@Override
	public Iterator<T> interator() {
		return new LOLIterator<T>(head);
	}

	@Override
	public String toString() {
		String s = "";
		s += "LinkedOrderedList[";

		Node<T> current = head;
		while (current != null) {
			s += current.element;
			current = current.next;
		}
		s += "]";
		return s;
	}

	// OrderedListADT method
	@Override
	public void add(T element) {
		Node<T> newNode = new Node<T>();
		newNode.element = element;

		if (isEmpty()) {
			head = newNode;
		} else if (size() == 1) {
			if (newNode.element.compareTo(head.element) < 0) {
				// new node is smaller than head node
				newNode.next = head;
				head = newNode;
			} else {
				// new node goes after
				head.next = newNode;
			}
		} else {
			Node<T> curr = head, trail = null;
			while (curr != null && curr.element.compareTo(element) <= 0) {
				trail = curr;
				curr = curr.next;
			}

			if (head == curr) {
				newNode.next = head;
				head = newNode;
			} else {
				trail.next = newNode;
				newNode.next = curr;
			}
		}
		count++;
	}

}
