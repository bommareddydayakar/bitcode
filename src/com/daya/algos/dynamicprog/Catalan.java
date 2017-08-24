package com.daya.algos.dynamicprog;

public class Catalan {
	public static void main(String[] args) {
		int n = 3;
		System.out.println("The Catalan Number is(REC): "+catalanRec(9));
		System.out.println("The Catalan Number is(TAB): "+catalanTab(9));
	}

	private static int catalanRec(int n) {
		if(n == 0 || n == 1)
			return 1;
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += catalanRec(i)*catalanRec(n-1-i);
			
		}
		return total;
	}
	private static int catalanTab(int n) {
		int[] dict = new int[n+1];
		dict[0] = 1;
		for (int i = 1; i <= n; i++) {
			int total = 0;
			
			for (int j = 0; j < i; j++) {
				total += dict[j]*dict[i-j-1];
			}
			dict[i] = total;
		}
		
		
		return dict[n];
		//[1, 1, 2, 5, 14, 42, 132, 429, 1430]
	}
}
