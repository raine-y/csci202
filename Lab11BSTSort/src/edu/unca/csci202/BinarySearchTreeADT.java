/**
 * 
 */
package edu.unca.csci202;

/**
 * @author Brian Drawert
 * @data Oct 28th, 2020
 */
public interface BinarySearchTreeADT<T extends Comparable<T>> extends BinaryTreeADT<T> {

	/**
	 * Return the number of elements in the tree
	 * @return the number of elements in the tree
	 */
	public int size();              // do this in lab 11

	/**
	 * Return the largest element in the tree
	 * @return the largest element in the tree
	 */
	public T maximum();             // do this in lab 11

	/**
	 * Return the smallest element in the tree
	 * @return the smallest element in the tree
	 */
	public T minimum();             // do this in lab 11
	
	/**
	 * Get height of tree in number of nodes
	 * @returns height of tree in number of nodes
	 */	
	public int height();            // do this in lab 11

	/**
	 * Insert into the BST.
	 * @param element to insert
	 */
	public void insert(T element);   // do this in lab 11
	
	/**
	 * Remove an element from the tree
	 * @param element to be removed from the tree
	 */
	public void delete(T element);	// not needed for lab 11

	/**
	 * Find and return an element in the tree that is equal to parameter
	 * @param element to be searched for
	 * @return element found, or null if not found in tree
	 */
	public T find(T element);       // not needed for lab 11. will override the BinaryTree.
	
	/**
	 * Determine if an element in the tree that is equal to the parameter exists
	 * @param element to be searched for
	 * @return true if matching element exists, false otherwise
	 */
	boolean contains(T element);    // not needed for lab 11. will override the BinaryTree.
	

	
	

	
}
