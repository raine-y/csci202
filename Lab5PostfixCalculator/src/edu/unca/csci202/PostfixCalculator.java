package edu.unca.csci202;

import java.util.Scanner;

public class PostfixCalculator {
	LinkedStack<Double> operationStack;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			PostfixCalculator operation = new PostfixCalculator();
			System.out.print(":::> ");
			String input = scanner.nextLine();

			try {
				double result = operation.calculate(input);
				System.out.println(result);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
	}

	public PostfixCalculator() {
		operationStack = new LinkedStack<Double>();
	}

	public double calculate(String operationText) {
		Scanner scanner = new Scanner(operationText);
		while (scanner.hasNext()) {
			String curToken = scanner.next();

			if (curToken.equalsIgnoreCase("q")) {
				System.out.println("Goodbye!");
				System.exit(0);
			} else if (curToken.equals("+") || curToken.equals("-") || curToken.equals("*") || curToken.equals("/")) {
				try {
					double secondOperand = operationStack.pop();
					double firstOperand = operationStack.pop();

					switch (curToken) {
					case "+":
						operationStack.push(firstOperand + secondOperand);
						break;
					case "-":
						operationStack.push(firstOperand - secondOperand);
						break;
					case "*":
						operationStack.push(firstOperand * secondOperand);
						break;
					case "/":
						if (secondOperand == 0)
							throw new ArithmeticException("Invalid input: divided by zero\n");
						operationStack.push(firstOperand / secondOperand);
						break;
					}
				} catch (EmptyCollectionException e) {
					throw new IllegalArgumentException("Invalid input: not enough operands\n");
				}
			} else {
				try {
					operationStack.push(Double.parseDouble(curToken));
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("Invalid input: unrecognized token: " + curToken + "\n");
				}
			}
		}

		double result = operationStack.pop();
		if (!operationStack.isEmpty()) {
			throw new IllegalStateException("Invalid input: too many operands\n");
		}

		return result;
	}
}