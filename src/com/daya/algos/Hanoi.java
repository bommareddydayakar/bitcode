package com.daya.algos;

import java.util.Stack;

public class Hanoi {
	public static void main(String[] args) {
		Stack<Integer> from = new Stack<Integer>();
		Stack<Integer> to = new Stack<Integer>();
		Stack<Integer> spare = new Stack<Integer>();
		
		from.push(5);
		from.push(4);
		from.push(3);
		from.push(2);
		from.push(1);
		
		hanoi(from.size(),from,to,spare);
		
		int item = to.pop();
		while(true){
			System.out.println(item);
			if(to.isEmpty())
				break;
			item = to.pop();
		}
		
		
	}
	private static void hanoi(int n,Stack<Integer> from, Stack<Integer> to, Stack<Integer> spare) {
		if(n==1){
			if(from.size()>0){
				int item = from.pop();
				to.push(item);
			}			
		}else if(n > 1){
			hanoi(n-1,from,spare,to);
			hanoi(1,from,to,spare);
			hanoi(n-1,spare,to,from);
		}
	}
}
