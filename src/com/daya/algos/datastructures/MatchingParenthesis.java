package com.daya.algos.datastructures;

public class MatchingParenthesis {
	public static void main(String[] args) {
		char exp[] = { '{', '(', ')', '}', '[', ']' };
		if (areParenthesisBalanced(exp))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}

	private static boolean areParenthesisBalanced(char[] exp) {
		if (exp == null || exp.length <= 0)
			return false;
		Stack stack = new Stack();
		for (int i = 0; i < exp.length; i++) {
			switch (exp[i]) {
			case '}':
				if (stack.pop() != '{')
					return false;
				break;
			case ']':
				if (stack.pop() != '[')
					return false;
				break;
			case ')':
				if (stack.pop() != '(')
					return false;
				break;
			default:
				stack.push(exp[i]);
				break;
			}
		}

		return stack.isEmpty() ? true : false;
	}
}

class Stack {
	int top;
	char items[];

	public Stack() {
		top = -1;
		items = new char[100];
	}

	public void push(char c) {
		if (top + 1 >= items.length) {
			char[] newItems = new char[items.length + 100];
			for (int i = 0; i < items.length; i++) {
				newItems[i] = items[i];
			}
			items = newItems;
		}
		items[++top] = c;
	}

	public char pop() {
		char c = items[top];
		items[top] = ' ';
		top--;
		return c;
	}

	public char peek() {
		return items[top];
	}

	public boolean isEmpty() {
		return (top < 0) ? true : false;
	}

}
