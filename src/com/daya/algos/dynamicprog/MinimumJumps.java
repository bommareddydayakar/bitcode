package com.equinix.algos.dynamicprog;

public class MinimumJumps {
	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 3, 2, 6, 2, 6, 8, 9 };
		//int arr[] = { 1, 3, 5, 8, 1, 2, 1, 2,1,5};
		
//		System.out.println("Minimum number of jumps needed are: " + minJumpsRec(arr, 0));
		System.out.println("Minimum number of jumps needed are: " + minJumpsTab(arr));
		
	}

	private static int minJumpsRec(int[] arr, int be) {

		if( be >= arr.length-1 || arr[be] == 0)
			return 0;

		int end = Math.min(be + arr[be], arr.length - 1);
		int min = Integer.MIN_VALUE;
		int tmp = Integer.MAX_VALUE ;
		for (int i = be+1; i <= end; i++) {
			tmp = 1 + minJumpsRec(arr, i);
		}
		if (min < tmp)
			min = tmp;
		
		return min;
	}
	
	private static int minJumpsTab(int[] arr) {

		int[] dict = new int[arr.length];
		
		for (int i = 0; i < arr.length-1;) {
			if(i == arr.length-1){
				break;
			}
			if(arr[i] == 0){
				dict[i] = 0;
				break;
			}else{
				dict[i]++;
				i=Math.min(i+arr[i], arr.length-1);
			}
		}
				
		return dict[arr.length-1];
	}
	
	
	
	
}
