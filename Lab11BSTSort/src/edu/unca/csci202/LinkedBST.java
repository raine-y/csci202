package edu.unca.csci202;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class LinkedBST<T extends Comparable<T>> implements BinarySearchTreeADT<T>, Iterable<T> {
	// inner node close
	private class BSTNode<T> {
		private T data;
		private BSTNode<T> left, right, parent;

		// constructor
		public BSTNode(T data) {
			this.data = data;
			left = right = parent = null;
		}
	}

	// linkedBST data fields
	private int size;
	private BSTNode<T> root;

	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	@Override
	public T getRootElement() {
		if (isEmpty())
			return null;
		else
			return root.data;
	}

	@Override
	public Iterator<T> iterator() {
		return iteratorInOrder();
	}

	// in-order (left -> root -> right)
	@Override
	public Iterator<T> iteratorInOrder() {
		ArrayList<T> list = new ArrayList<>();
		inOrder(root, list);
		return list.iterator();
	}

	// in-order recursion helper
	private void inOrder(BSTNode n, ArrayList<T> list) {
		if (n == null)
			return;
		inOrder(n.left, list);
		list.add((T) n.data);
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
	private void preOrder(BSTNode n, ArrayList<T> list) {
		if (n == null)
			return;
		list.add((T) n.data);
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
	private void postOrder(BSTNode n, ArrayList<T> list) {
		if (n == null)
			return;
		postOrder(n.left, list);
		postOrder(n.right, list);
		list.add((T) n.data);

	}

	// by level - using a fifo-esc queue!
	public Iterator<T> iteratorLevelOrder() {
		ArrayList<T> list = new ArrayList<>();
		if (root == null)
			return list.iterator();
		Queue<BSTNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) { // it is like Minsweeper :o
			BSTNode curr = queue.poll();
			list.add((T) curr.data);
			if (curr.left != null)
				queue.add(curr.left);
			if (curr.right != null)
				queue.add(curr.right);
		}

		return list.iterator();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T maximum() {
		if (root == null)
			return null;
		return maximum(root).data;
	}

	private BSTNode<T> maximum(BSTNode<T> x) {
		while (x.right != null)
			x = x.right;
		return x;
	}

	@Override
	public T minimum() {
		if (root == null)
			return null;
		return minimum(root).data;
	}

	private BSTNode<T> minimum(BSTNode<T> x) {
		while (x.left != null)
			x = x.left;
		return x;
	}

	@Override
	public int height() {
		return heightHelper(root);
	}

	/**
	 * Private recursive helper method used by public height method. Finds height of
	 * given node subtree.
	 * 
	 * @param x Find the height of x's subtree
	 * @return height of subtree
	 */
	private int heightHelper(BSTNode<T> x) {
		if (x == null)
			return 0; // height is 1 + tallest subtree
		return Math.max(heightHelper(x.left), heightHelper(x.right)) + 1;
	}

	@Override
	public void insert(T element) {
		size++;
		BSTNode<T> z = new BSTNode<>(element);
		BSTNode<T> x = root; // loop var
		BSTNode<T> y = null; // trailing pointer
		while (x != null) {
			y = x;
			if (z.data.compareTo(x.data) < 0) // z is smaller
				x = x.left;
			else
				x = x.right;

		}
		z.parent = y;
		if (y == null)
			root = z;
		else if (z.data.compareTo(y.data) < 0)
			y.left = z;
		else
			y.right = z;
	}

	@Override
	public void delete(T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public T find(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * public String toString() { return recursiveTreeString(root, 0); }
	 */

}
