package edu.unca.csci202;

abstract public class SuperSort { //superClass, alt: INHERITANCE MENTIONED
	protected long numOfComparisions;
	protected long numOfMoves;
	
	public SuperSort() {
		numOfComparisions = 0;
		numOfMoves = 0;
	}
	
	public abstract void sort(int[] a, boolean debugMode);
	
	public void printStats() {
		System.out.println("* Stats *");
		System.out.println("Number of comparisons: " + numOfComparisions);
		System.out.println("Number of items moved: " + numOfMoves);
	}
}
