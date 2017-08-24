package com.daya.algos.dynamicprog;

public class TilingNX4 {
	public static void main(String[] args) {
		int n = 5;
		System.out.println("Number of ways we can fill 2X"+n+" grid with 4X1 tiles are:"+count(n));
		
		//DP Memoization
		int[] res = new int[n+1];
		for (int i = 0; i < res.length; i++) {
			res[i] = -1;
		}
		//System.out.println("Number of ways we can fill 2X"+n+" grid with 2X1 tiles are:"+countDPMem(n, res));
		
		//System.out.println("Number of ways we can fill 4X"+n+" grid with 4X1 tiles are:"+countDPTab(n));
	}

	private static int count(int n) {
		if(n <= 3)
			return 1;
		if(n == 4)
			return 2;
		
		
		return count(n-1) + count(n-4);
	}
	
	private static int countDPMem(int n,int[] res) {
		if(res[n] != -1)
			return res[n];
		
		if(n <= 2)
			res[n] = n;
		else
			res[n] = count(n-1)+count(n-2);
		
		return res[n];
	}
	
	
	private static int countDPTab(int n) {
		int[] dict = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			if(i == 1 || i == 2)
				dict[i] = i;
			else{
				dict[i] = dict[i-1]+dict[i-2];
			}
		}
		
		
		return dict[n];
	}
	
	
	
	
}
