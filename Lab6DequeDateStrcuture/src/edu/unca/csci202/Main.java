package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {
		DequeADT<String> deque = new LinkedDeque<String>();
		deque.addFirst("A");
		deque.addFirst("B");
		deque.addFirst("C");
		deque.addFirst("D");
		deque.addFirst("E");
		deque.addFirst("F");
		deque.addFirst("G");
		deque.addFirst("H");
		deque.addFirst("I");
		deque.addFirst("J");
		System.out.println(deque);
		for (int i = 0; i < 5; i++)
			deque.removeLast();
		System.out.println(deque);
		deque.addLast("1");
		deque.addLast("2");
		deque.addLast("3");
		deque.addLast("4");
		deque.addLast("5");
		System.out.println(deque);
		circularRightShift(deque, 10);
		System.out.println(deque);
		circularLeftShift(deque, 10);
		System.out.println(deque);
		System.out.println("Last element: " + deque.getLast());
		
		System.out.println(""); // spacer
		
		StackADT<String> stack = new LinkedDeque<String>();
		stack.push("Z");
		stack.push("Y");
		stack.push("X");
		stack.push("W");
		stack.push("V");
		System.out.println(stack);
		while (stack.isEmpty() == false) {
			String cur = stack.pop();
			System.out.println(cur);
		}
		
		System.out.println(""); // spacer
		
		QueueADT<String> queue = new LinkedDeque<String>();
		queue.enqueue("!");
		queue.enqueue("@");
		queue.enqueue("#");
		queue.enqueue("$");
		queue.enqueue("%");
		System.out.println(queue);
		while (queue.isEmpty() == false) {
			String cur = queue.dequeue();
			System.out.println(cur);
		}
	}
	
	static DequeADT<String> circularRightShift(DequeADT<String> deque, int i) {
		System.out.println("Circular right shift:");
		while (i > 0) {
			String back = deque.removeLast();
			deque.addFirst(back);
			System.out.println(deque);
			i--;
		}
		System.out.println("Circular right shift finished.");
		return deque;
	}
	
	static DequeADT<String> circularLeftShift(DequeADT<String> deque, int i) {
		System.out.println("Circular left shift:");
		while (i > 0) {
			String back = deque.removeFirst();
			deque.addLast(back);
			System.out.println(deque);
			i--;
		}
		System.out.println("Circular left shift finished.");
		return deque;
	}
}