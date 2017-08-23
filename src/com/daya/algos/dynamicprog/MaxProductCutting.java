package com.equinix.algos.dynamicprog;

public class MaxProductCutting {
	public static void main(String[] args) {
		int n= 10;
		int[] res = new int[n];
		for (int i = 0; i < res.length; i++) {
			res[i] = -1;
		}
		System.out.println(maxProductDP(n,res));
	}

	private static int maxProductRec(int n) {
		if(n<1)
			return 0;
		int max = Integer.MIN_VALUE;
		for(int i=1;i<n;i++){
			max = Math.max(max, Math.max(i*(n-i),maxProductRec(n-i)*i));
		}
		
		return max;
		
	}
	
	private static int maxProductDP(int n,int[] res) {
		if(res[n-1] != -1){
			return res[n];
		}
		if(n<1)
			return 0;
		int max = Integer.MIN_VALUE;
		for(int i=1;i<n;i++){
			max = Math.max(max, Math.max(i*(n-i),maxProductDP(n-i,res)*i));
		}
		res[n-1] = max;
		return max;
		
	}
}
