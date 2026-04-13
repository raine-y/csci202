package edu.unca.csci202;

import java.util.Iterator;

public interface BinaryTreeADT<T extends Comparable<T>> {


	/**
	 * return true if tree is empty, false otherwise
	 * 
	 * @return true is tree is empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * the number of nodes in this tree
	 * 
	 * @return the number of nodes in this tree
	 */
	public int size();
	
	/**
	 * return the element of the root node
	 * 
	 * @return the element of the root node, or null if tree is empty
	 */
	public T getRootElement();

	/**
	 * return true if some element of the tree equals targetElement
	 * 
	 * @param targetElement element we're looking for a match
	 * @return true if some element of the tree equals targetElement, false if there
	 *         are none matching
	 */
	public boolean contains(T targetElement);

	/**
	 * return a handle to an element in the tree that equals targetElement, or null
	 * if there are none
	 * 
	 * @param targetElement the element we're looking for a match
	 * @return a handle to an element that equals targetElement from this tree, or
	 *         returns null if there is none matching
	 */
	public T find(T targetElement);

	/**
	 * return an in order iterator of all this tree's elements
	 * @return an in order iterator of all this tree's elements
	 */
	public Iterator<T> iteratorInOrder();

	/**
	 * return a pre order iterator of all this tree's elements
	 * @return a pre order iterator of all this tree's elements
	 */
	public Iterator<T> iteratorPreOrder();

	/**
	 * return a post order iterator of all this tree's elements
	 * @return a post order iterator of all this tree's elements
	 */
	public Iterator<T> iteratorPostOrder();

	/**
	 * return a level order iterator of all this tree's elements
	 * @return a level order iterator of all this tree's elements
	 */
	public Iterator<T> iteratorLevelOrder();
}
