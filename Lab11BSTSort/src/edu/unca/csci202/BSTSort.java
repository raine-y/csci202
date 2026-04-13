package edu.unca.csci202;

import java.util.Iterator;
import java.util.LinkedList;

public class BSTSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

	protected BinarySearchTreeADT<T> tree;
	protected LinkedList<T> list;
	protected boolean debug;

	public BinarySearchTreeADT<T> getTree() {
		return this.tree;
	}

	public BSTSort() {
		this.list = new LinkedList<T>();
		this.tree = new LinkedBST<T>();
		this.debug = false;
	}

	public BSTSort(boolean debug) {
		this.list = new LinkedList<T>();
		this.tree = new LinkedBST<T>();
		this.debug = debug;

	}

	public void addToBack(T element) {
		this.list.add(element);
	}

	public void clear() {
		this.list.clear();
		this.tree = new LinkedBST<T>();
	}

	public void printStats() {
		System.out.print("  size=" + this.tree.size());
		System.out.println("  heightOfTree=" + this.tree.height());
		if (this.debug)
			System.out.println(this.tree);
	}

	public String toString() {
		String ret = "[";
		Iterator<T> itr = this.tree.iteratorInOrder();
		while (itr.hasNext()) {
			ret += itr.next() + ", ";
		}
		return ret + "]";
	}
	
	public void sort() {
		Iterator<T> itr = this.list.iterator();
		while (itr.hasNext()) {
			this.tree.insert(itr.next());
		}

	}
}
