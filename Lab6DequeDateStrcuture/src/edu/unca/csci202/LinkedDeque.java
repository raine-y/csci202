package edu.unca.csci202;

public class LinkedDeque<T> implements StackADT<T>, QueueADT<T>, DequeADT<T> {
	// private
	@SuppressWarnings("hiding")
	private class DNode<T> { // double-linked list node
		private DNode<T> next;
		private DNode<T> prev;
		private T element;
		// default imp constructor nulls handles 
	}
	
	//data fields
	private DNode<T> head;
	private DNode<T> tail;
	private int count;
	
	public LinkedDeque() {
		head = tail = null;
		count = 0;
	}
	
	// DequeADT
	@Override
	public void addFirst(T element) {
		DNode<T> newNode = new DNode<>();
		// new node unlinked & element-less
		newNode.element = element; 
		
		//special case: empty list getting it's first node
		if(isEmpty()) {
			head = tail = newNode;
		} else {
			//plugging new node into old head node
			newNode.next = head;
			// old head points to new node
			head.prev = newNode;
			// new current head
			head = newNode;
		}
		count++;
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) throw new EmptyCollectionException("LinkedDeque is empty");
		T firstElement = head.element;
		
		if (size() == 1) { // only one node
			head = tail = null;
		} else {
			head = head.next;
			head.prev = null;
			// Java GC kills that first node for us
		}
		count--;
		return firstElement;
	}

	@Override
	public T getFirst() {
		if (isEmpty()) throw new EmptyCollectionException("LinkedDeque is empty");
		return head.element;
	}

	@Override
	public void addLast(T element) {
		DNode<T> newNode = new DNode<>();
		newNode.element = element; 
			if(isEmpty()) {
				head = tail = newNode;
			} else {
				// list was not empty, so
				// attach the new node after the old tail
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			count++;
	}

	@Override
	public T removeLast() {
		if (isEmpty()) throw new EmptyCollectionException("LinkedDeque is empty");
		T lastElement = tail.element;
		
		if (size() == 1) { // only one node
			head = tail = null;
		} else {
			tail = tail.prev;
			tail.next = null; // disconnecting last node from second to last
			// Java GC once again kills that last node for us
		}
		count--;
		return lastElement;	}

	@Override
	public T getLast() {
		if (isEmpty()) throw new EmptyCollectionException("LinkedDeque is empty");
		return tail.element;
	}

	// QueueADT
	@Override
	public void enqueue(T element) {// wrapper method
		addLast(element);
	}
	
	@Override
	public T dequeue() {
		return removeFirst();
	}

	@Override
	public T first() {
		return getFirst();
	}

	// StackADT
	@Override
	public void push(T element) {
		addFirst(element);
	}

	@Override
	public T pop() {
		return removeFirst();
	}

	@Override
	public T peek() {
		if (isEmpty()) throw new EmptyCollectionException("ArrayStack");
		return head.element;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}
	
	@Override
	public String toString() {
		String str = (String) head.element;
		DNode<T> temp = head;
		while (temp.next != null) {
			str = str.concat((String) temp.next.element);
			temp = temp.next;
		}
		return str;
	}

}
