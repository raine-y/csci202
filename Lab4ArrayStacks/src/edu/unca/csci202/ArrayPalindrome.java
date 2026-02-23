package edu.unca.csci202;

public class ArrayPalindrome {
	ArrayStack<Character> stack1;
	ArrayStack<Character> stack2;
	ArrayStack<Character> stack3;

	public static void main(String[] args) {
		String[] stringToCheck = { "racecar", "raceecar", "palindrome", "tattarrattat", "okay", "detartrated", "i" };
		ArrayPalindrome checker = new ArrayPalindrome();
		for (int i = 0; i < stringToCheck.length; i++) {
			boolean cur = checker.isPalindrome(stringToCheck[i]);
			if (cur)
				System.out.println(stringToCheck[i] + " is a palindrome");
			else
				System.out.println(stringToCheck[i] + " is not a palindrome");
		}
	}

	public ArrayPalindrome() {
		stack1 = new ArrayStack<Character>();
		stack2 = new ArrayStack<Character>();
		stack3 = new ArrayStack<Character>();
	}

	/**
	 * Tell if given string is a palindrome
	 * 
	 * @param s is the string to test
	 * @return true if s is a palindrome
	 */
	public boolean isPalindrome(String s) {
		// 1. push all char from s onto stack1 & stack2
		// using a loop
		for (int i = 0; i < s.length(); i++) {
			stack1.push(s.charAt(i));
			stack2.push(s.charAt(i));
		}
		// 2. pop everything from stack1 & push it into
		// stack3 so stack3 is backwards
		for (int i = 0; i < s.length(); i++) {
			stack3.push(stack1.pop());
		}
		// 3. pop letters off of stack2 & stack3 at a time
		// and make sure they match.
		// return false if mismatch
		for (int i = 0; i < s.length(); i++) {
			if (stack2.pop() == stack3.pop())
				;
			else
				return false;
		}
		// 4. when the code reaches here we never found a
		// mismatch; return true.
		return true;
	}
}