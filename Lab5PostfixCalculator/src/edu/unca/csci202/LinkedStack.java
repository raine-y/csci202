package edu.unca.csci202;

import java.util.Arrays;

public class LinkedStack<T> implements StackADT<T> {

	private int top;
	private T[] arr; // holds elements
	public static final int DEFAULT_LEN = 10;

	
	@SuppressWarnings("unchecked")
	public LinkedStack() {
		arr = (T[]) new Object[DEFAULT_LEN];
		top = 0;
	}
	
	@Override
	public void push(T element) {
		if(size() == arr.length) // if array is full
			Arrays.copyOf(arr, arr.length * 2); // double array length
		arr[top] = element;
		top++;		
	}

	@Override
	public T pop() {
		if (isEmpty()) throw new EmptyCollectionException("ArrayStack");
		top--;
		T temp = arr[top];
		arr[top] = null;
		return temp;
	}

	@Override
	public T peek() {
		if (isEmpty()) throw new EmptyCollectionException("ArrayStack");
		return arr[top - 1];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return top;
	}
	
	public String toString() {
		return null;
	}
}
