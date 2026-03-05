package edu.unca.csci202;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract interface ListADT<T> {
	/**
	 * removes first element from list
	 * @return first element from list
	 * @throws NoSuchElementException when the list is empty i.e.
	 * there is no first element
	 */
	public T removeFirst() throws NoSuchElementException;
	
	/**
	 * removes last element from list
	 * @return last element from list
	 * @throws NoSuchElementException when the list is empty i.e.
	 * there is no last element
	 */
	public T removeLast() throws NoSuchElementException;
	
	/**
	 * locate an item in the list equal to the param. element & then remove 
	 * element from list & and return that element
	 * @param element we are looking for in the list
	 * @return element from list equal to param element
	 * @throws NoSuchElementException if no item in list is equal to param 
	 * element
	 */
	public T remove(T element) throws NoSuchElementException;
	
	/**
	 * obtain & return the first element of the list w/o removing it
	 * @return first element of list
	 * @throws NoSuchElementException if list is empty
	 */
	public T first() throws NoSuchElementException;
	
	/**
	 * obtain & return the last element of the list w/o removing it
	 * @return last element of list
	 * @throws NoSuchElementException if list is empty
	 */
	public T last() throws NoSuchElementException;
	
	/**
	 * return if true is empty, false otherwise
	 * @return bool
	 */
	public boolean isEmpty();
	
	/**
	 * return number of elements in list
	 * @return number of elements in list
	 */
	public int size();
	
	/**
	 * create and return an Iterator of the list
	 * @return return an Iterator of the list
	 */
	public Iterator<T> interator();
	
	// toString is not technically going into this interface
	// but nonetheless we'll override define toString in classes later
}
