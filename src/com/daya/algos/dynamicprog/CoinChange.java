package com.daya.algos.dynamicprog;

public class CoinChange {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int n = 4;
		int[][] result = new int[n+1][n+1];
		for(int i=0;i<n+1;i++){
			for(int j=0;j<n+1;j++){
				result[i][j] = -1;
			}
		}
		System.out.println("Possible coin change sets RECURSIVE:"+coinChange(arr,arr.length,n));
		System.out.println("Possible coin change sets MEMOIZATION:"+coinChange(arr,arr.length,n,result));	
	}

	private static int coinChange(int[] arr, int length, int n) {
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		if(length <= 0 && n>0)
			return 0;
		
		return coinChange(arr,length-1,n)+coinChange(arr,length,n-arr[length-1]);
	}
	
	private static int coinChange(int[] arr, int length, int n,int[][] res) {
		
		if(length>-1 && n > -1 && res[length][n] != -1)
			return res[length][n];
		int val = -1;
		if(n==0){
			res[length][n] = 1;
			return 1;
		}
		if(n<0)
			return 0;
		if(length <= 0 && n>0)
			return 0;
		
		val = coinChange(arr,length-1,n,res)+coinChange(arr,length,n-arr[length-1],res);
		res[length][n] = val;
		return val;
	}
	
}
