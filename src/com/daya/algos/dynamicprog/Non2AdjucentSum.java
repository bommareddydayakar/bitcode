package com.equinix.algos.dynamicprog;

public class Non2AdjucentSum {
	public static void main(String[] args) {
		int[] arr = {5, 5, 10, 100, 10};
		System.out.println("Max sum of non adjucent elements is:"+find2Sum(arr));
		
	}

	private static int find2Sum(int[] arr) {
		int odd = 0, even = 0;
		for (int i = 0; i < arr.length; ++i) {
			odd += arr[i];
			if(i+1 < arr.length)
				even += arr[++i];
		}
		
		return Math.min(odd, even);
		
	}
}
