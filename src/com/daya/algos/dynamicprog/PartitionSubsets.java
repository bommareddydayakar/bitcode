package com.daya.algos.dynamicprog;

public class PartitionSubsets {
	public static void main(String[] args) {
		int[] arr = {30,4};
		int sumTotal = 0;
		for (int i : arr) {
			sumTotal += i;
		}
		System.out.println("The minimum difference between two subsets is:"+findMinDef(arr,arr.length,0,sumTotal)+":"+count);
	}
	static int count = 0;
	private static int findMinDef(int[] arr, int length, int interimSum, int sumTotal) {
		count++;
		if(length == 0){
			return Math.abs((sumTotal-interimSum)-interimSum);
		}else{
			return Math.min(findMinDef(arr,length-1, (interimSum+arr[length-1]), sumTotal),findMinDef(arr,length-1, interimSum, sumTotal));
		}
	}
}
