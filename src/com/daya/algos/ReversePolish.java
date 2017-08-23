package com.equinix.algos;

import java.util.Stack;

public class ReversePolish {
	public static void main(String[] args) {
		//String a[] = {"2", "1", "+", "3", "*"};
		/*String a[] = {"10"};
		System.out.println(calculate(a));
		*/
		
		String a = "{}";
		System.out.println(matchParenth(a));
	}
	
	public static boolean matchParenth(String str) {
		Stack<Character> stack = new Stack<Character>();
		if (str == null || str.length() == 0 || str.length() == 1)
			return false;
		else {
			char[] arr = str.toCharArray();
			String openRef = "({[";
			String closeRef = ")}]";

			for (char item : arr) {
				int openInd = openRef.indexOf(item);
				int closeInd = closeRef.indexOf(item);

				if (openInd > -1) {
					stack.push(item);
				} else if (closeInd > -1) {
					if (stack.isEmpty())
						return false;
					char stackItm = stack.pop();
					if (stackItm != openRef.charAt(closeInd))
						return false;
				}
			}
		}
		if(!stack.isEmpty())
			return false;
		return true;
	}
	public static int calculate(String[] arr){
		if(arr == null || arr.length ==0)
			return 0;
		else{
			Stack<Long> stack = new Stack<Long>();
			for (String item : arr) {
				try{
					Long lng = Long.parseLong(item);
					stack.push(lng);
				}catch(NumberFormatException e){
					long two = stack.pop();
					long one = stack.pop();
					switch(item){
					case "+":
						stack.push(one+two);
						break;
					case "-":
						stack.push(one-two);
						break;
					case "*":
						stack.push(one*two);
						break;
					case "/":
						stack.push(one/two);
						break;
					default:
						return 0;
					}
				}
				
			}
			return stack.pop().intValue();
		}
	}
}

