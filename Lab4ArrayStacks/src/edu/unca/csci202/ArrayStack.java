package edu.unca.csci202;

import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T> {
	// data fields a.k.a instance variables
	private T[] array; // holds the elements
	private int top; // also size of stack. 0 = empty
	/**
	 * The default size of a new stack array
	 */
	public static final int DEFAULT_CAPACITY = 100;

	// constructors
	/**
	 * Default constructor to make a new stack with array length default 100
	 */
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Construct a stack with the given initialCapacity as array length
	 * 
	 * @param initialCapacity initial length of array
	 */

	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		array = (T[]) new Object[initialCapacity];
		top = 0;
	}

	@Override
	public void push(T element) {
		if(size() == array.length) // if array is full
			Arrays.copyOf(array, array.length * 2); // double array length
		array[top] = element;
		top++;
	}

	@Override
	public T pop() {
		if (isEmpty()) throw new EmptyCollectionException("ArrayStack");
		top--;
		T temp = array[top];
		array[top] = null;
		return temp;
	}

	@Override
	public T peek() {
		if (isEmpty()) throw new EmptyCollectionException("ArrayStack");
		return array[top - 1];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return top;
	}
	
	/**
	 * sanity check
	 * @param args
	 */
	/* public static void main(String[] args) {
		ArrayStack<Integer> s = new ArrayStack<Integer is implied>();
		s.push(1);
		s.push(2);
		s.push(3);
		while(!s.isEmpty())
			System.out.println(s.pop());
	}*/
}
