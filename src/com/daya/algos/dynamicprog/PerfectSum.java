package com.equinix.algos.dynamicprog;

import java.util.HashMap;
import java.util.Map;

public class PerfectSum {
	public static void main(String[] args) {
		int[] arr = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		print2SetSum(arr,sum);
	}

	private static void print2SetSum(int[] arr, int sum) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++){
			int tmp = sum-arr[i];
			if(map.get(arr[i])==null)
				map.put(tmp, i);
			else{
				System.out.println(map.get(arr[i])+":"+i);
			}
		}
	}
}
