package com.equinix.algos.dynamicprog;

public class LongestIncrSubsequence {
	
	
	public static void main(String args[])
	{
	    int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
	    System.out.println(lis(arr,arr.length));
	    
	}

	private static int lis(int[] arr, int length) {
		int lis[] = new int[length];
		for (int i =0;i<lis.length;i++) {
			lis[i] = 1;
		}
		int max = -1;
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[j] < arr[i] && lis[i] < 1+lis[j]){
					lis[i] = 1+ lis[j];
					max = Math.max(lis[i], max);
				}
			}
		}
		
		return max;
	}
}
