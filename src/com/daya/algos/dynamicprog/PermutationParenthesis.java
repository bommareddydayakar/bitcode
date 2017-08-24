package com.daya.algos.dynamicprog;

public class PermutationParenthesis {
	
	public static void main(String[] args) {
		int n = 3;
		String s = "";
		System.out.println(permuParenth(n,n,s));
	}

	private static String permuParenth(int left, int right, String s) {
		if(left ==0 && right==0){
			System.out.println(s);
			s = "";
		}
		
		if(left>0){
			s+= "(" + permuParenth(left-1, right,s);
		}
		else if(left<right){
			s+= ")" + permuParenth(left, right-1,s);
		}
		else if(left == 1 && right == 1)
			s += "()";
		
		return s;	
	}
}
