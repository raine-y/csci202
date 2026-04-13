package edu.unca.csci202;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class LinkedBinaryTree<T extends Comparable<T>> implements BinaryTreeADT<T>, Iterable<T> {
	private Node root;

	private class Node {
		T element;
		Node left, right;

		Node(T element) {
			this.element = element;
		}
	}

	// 0-param empty tree
	public LinkedBinaryTree() {
		root = null;
	}

	// 1-param "rooted" tree
	public LinkedBinaryTree(T element) {
		root = new Node(element);
	}

	// 3-param tree with a root & 2 leaves
	public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
		root = new Node(element);
		if (left != null) {
		    root.left = left.root;
		} else {
		    root.left = null;
		}

		if (right != null) {
		    root.right = right.root;
		} else {
		    root.right = null;
		}
	}
	
	@Override
	public Iterator<T> iterator() {
	    return iteratorInOrder();
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return sizeHelper(root);
	}

	// helper method to recursivley count down the tree's "branches"
	public int sizeHelper(Node n) {
		// base case
		if (n == null)
			return 0;
		else
			return 1 + sizeHelper(n.left) + sizeHelper(n.right); // 1+ to count tha root
	}

	public T getRootElement() {
		if (root == null)
			return null;
		else
			return root.element;
	}

	@Override
	public boolean contains(T target) {
		return find(target) != null;
	}

	public T find(T target) {
		return findHelper(root, target);
	}

	private T findHelper(Node n, T t) {
		if (n == null)
			return null; // fails along path
		if (n.element.compareTo(t) == 0)
			return n.element; // found

		// recursive calls down left branches, checking right if left doesnt contain
		T left = findHelper(n.left, t);
		if (left != null)
			return left;

		return findHelper(n.right, t);
	}
	
	// in-order (left -> root -> right)
	@Override
	public Iterator<T> iteratorInOrder() {
	    ArrayList<T> list = new ArrayList<>();
	    inOrder(root, list);
	    return list.iterator();
	}
	
	// in-order recursion helper
	private void inOrder(Node n, ArrayList<T> list) {
		if (n == null)
			return;
		inOrder(n.left, list);
		list.add(n.element);
	    inOrder(n.right, list);
	}
	
	// pre-order (root -> left -> right)
	@Override
	public Iterator<T> iteratorPreOrder() {
		ArrayList<T> list = new ArrayList<>();
		preOrder(root, list);
		return list.iterator();
	}
	
	// pre-order helper
	private void preOrder(Node n, ArrayList<T> list) {
		if (n == null)
			return;
		list.add(n.element);
		preOrder(n.left, list);
		preOrder(n.right, list);
	}
	
	// left -> right -> root
	@Override
	public Iterator<T> iteratorPostOrder() {
		ArrayList<T> list = new ArrayList<>();
		postOrder(root, list);
		return list.iterator();
	}
	
	// post-order helper
	private void postOrder(Node n, ArrayList<T> list) {
		if (n == null)
			return;
		postOrder(n.left, list);
		postOrder(n.right, list);
		list.add(n.element);

	}
	
	// by level - using a fifo-esc queue!
	public Iterator<T> iteratorLevelOrder() {
	    ArrayList<T> list = new ArrayList<>();
	    if (root == null)
	    	return list.iterator();
	    Queue<Node> queue = new ArrayDeque<>();
	    queue.add(root);
	    
	    while (!queue.isEmpty()) { // it is like Minsweeper :o
	        Node curr = queue.poll();
	        list.add(curr.element);
	        if (curr.left  != null) queue.add(curr.left);
	        if (curr.right != null) queue.add(curr.right);
	    }

	    return list.iterator();
	}
	
	@Override
	public String toString() {
	    ArrayList<T> list = new ArrayList<>();
	    inOrder(root, list);
	    return list.toString();
	}
}
