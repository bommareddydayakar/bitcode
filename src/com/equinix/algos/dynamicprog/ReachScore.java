package com.equinix.algos.dynamicprog;

public class ReachScore {
	public static void main(String[] args) {
		int score = 20;
		int arr[] = { 3, 5,10 };
		System.out.println("Number of ways to reach 20 : " + reachScore(score, arr, arr.length));
	}
	static int ways = 0;
	
	private static int reachScore(int score, int[] arr, int length) {
		if(score == 0)
			return 1;
		if(length <=0 )
			return 0;
		if(length > 0 && score <0)
			return 0;
		return reachScore(score-arr[length-1],arr,length)+reachScore(score,arr,length-1);
	}
	
	
	
}
