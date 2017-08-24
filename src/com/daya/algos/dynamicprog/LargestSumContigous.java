package com.daya.algos.dynamicprog;

public class LargestSumContigous {
	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, 3};
		System.out.println("The largest contigous sum is:"+largestContSum(arr));
	}

	private static int largestContSum(int[] arr) {
		int max = 0, i_max =0;
		for (int i = 0; i < arr.length; i++) {
			i_max += arr[i];
			if(i_max < 0)
				i_max = 0;
			max = Math.max(max, i_max);
			
		}
		return max;
	}
}
