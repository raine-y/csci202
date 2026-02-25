package edu.unca.csci202;

/**
 * QueueADT defines the interface to a queue collection.
 *
 * @author Java Foundation
 * @version 4.0
 */
public interface QueueADT<T> {
	/**
	 * Adds one element to the rear of this queue.
	 * 
	 * @param element the element to be added to the rear of the queue
	 */
	public void enqueue(T element);

	/**
	 * Removes and returns the element at the front of this queue.
	 * 
	 * @return the element at the front of the queue
	 * @throws EmptyCollectionException if the queue is empty
	 */
	public T dequeue();

	/**
	 * Returns without removing the element at the front of this queue.
	 * 
	 * @return the first element in the queue
	 * @throws EmptyCollectionException if the queue is empty
	 */
	public T first();

	/**
	 * Returns true if this queue contains no elements.
	 * 
	 * @return true if the queue is empty, false if the queue is not empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this queue.
	 * 
	 * @return the number of elements in the queue
	 */
	public int size();

}
