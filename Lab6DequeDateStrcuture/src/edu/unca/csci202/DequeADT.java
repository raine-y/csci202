package edu.unca.csci202;

public interface DequeADT<T> {
	/**
	 * The DequeADT (double-ended queue) provides methods for inserting, deleting
	 * and getting either the first or last element of a sequence of elements.
	 */

	/**
	 * Adds a new element to the head of this deque.
	 * 
	 * @param element the element to insert at the head of this deque
	 */
	public void addFirst(T element);

	/**
	 * Removes and returns the head element of this deque.
	 * 
	 * @return the head element of this deque
	 * @throws EmptyCollectionException if the deque is empty
	 */
	public T removeFirst();

	/**
	 * @return the head element of this deque
	 * @throws EmptyCollectionException if the deque is empty
	 */
	public T getFirst();

	/**
	 * Adds a new element to the tail of this deque.
	 * 
	 * @param element the element to insert at the tail of this deque
	 */
	public void addLast(T element);

	/**
	 * Removes and returns the tail element of this deque.
	 * 
	 * @return the tail element of this deque
	 * @throws EmptyCollectionException if the deque is empty
	 */
	public T removeLast();

	/**
	 * @return the tail element of this deque
	 * @throws EmptyCollectionException if the deque is empty
	 */
	public T getLast();
	
	/**
	 * Returns true if this deque contains no elements.
	 * 
	 * @return true if the deque is empty, false if the deque is not empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this deque.
	 * 
	 * @return the number of elements in the deque
	 */
	public int size();

}
