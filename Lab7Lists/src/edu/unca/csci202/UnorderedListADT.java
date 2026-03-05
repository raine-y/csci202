package edu.unca.csci202;

import java.util.NoSuchElementException;

public interface UnorderedListADT<T extends Comparable<T>> extends ListADT<T> {
	/**
	 * add an element to the front of the list
	 * @param element to be added to the list
	 */
	public void addToFront(T element);
	
	/**
	 * add an element to the rear of the list
	 * @param element to be added to the list
	 */
	public void addToRear(T element);
	
	/**
	 * add a new param element to the list immediately after an item in the last equal to the target 
	 * @param element to be added to the list
	 * @param target place where param element is to follow after
	 * @throws if no such element matches target
	 */
	public void addAfter(T element, T target) throws NoSuchElementException;
}
