package com.equinix.algos.dynamicprog;

public class OptimalStrategy {
	public static void main(String[] args) {
		//int arr[] = {5,3,7,10};
		int arr[] = {8, 15, 3, 7,10,10};
		int result[][] = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				result[i][j] = -1;
			}
		}
		System.out.println("The max value user can select is:"+optimalVal(arr,0,arr.length-1,result)+":"+count2);
		System.out.println("The max value user can select is:"+optimalVal(arr,0,arr.length-1)+":"+count1);
	}
	static int count1 =0;
	static int count2 =0;
	
	private static int optimalVal(int[] arr, int be, int en) {
		count1++;
		if(be == en)
			return arr[be];
		else if(be+1 == en)
			return Math.max(arr[be],arr[en]);
		else{
			return Math.max(
					arr[be]+Math.min(optimalVal(arr,be+2,en), optimalVal(arr,be+1,en-1)),
					arr[en]+Math.min(optimalVal(arr,be+1,en-1), optimalVal(arr,be,en-2))					
					);
		}
	}
	
	
	private static int optimalVal(int[] arr, int be, int en, int[][] result) {
		count2++;
		if(result[be][en] != -1)
			return result[be][en];
		
		if(be == en){
			result[be][en] = arr[be];
		}
		else if(be+1 == en){
			result[be][en] = Math.max(arr[be],arr[en]);
		}
		else{
			result[be][en] = Math.max(
				arr[be]+Math.min(optimalVal(arr,be+2,en, result), optimalVal(arr,be+1,en-1, result)),
				arr[en]+Math.min(optimalVal(arr,be+1,en-1, result), optimalVal(arr,be,en-2, result))					
			); 
		}
		return result[be][en];
	}
}
