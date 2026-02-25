package edu.unca.csci202;

/**
 * Defines the interface to a stack collection.
 *
 * @author Java Foundations
 * @version 4.0
 */
public interface StackADT<T> {
	/**
	 * Adds the specified element to the top of this stack.
	 * 
	 * @param element element to be pushed onto the stack
	 */
	public void push(T element);

	/**
	 * Removes and returns the top element from this stack.
	 * 
	 * @return the element removed from the stack
	 * @throws EmptyCollectionException if the stack is empty
	 */
	public T pop();

	/**
	 * Returns the top element of this stack without removing it from the stack.
	 * 
	 * @return the element on top of the stack. It is not removed from the stack
	 * @throws EmptyCollectionException if the stack is empty
	 */
	public T peek();

	/**
	 * Returns true if this stack contains no elements.
	 * 
	 * @return true if the stack is empty, false if the stack is not empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this stack.
	 * 
	 * @return the number of elements in the stack
	 */
	public int size();

}
