package com.equinix.algos;

import java.util.ArrayList;
import java.util.List;

public class Ranges {
	public static void main(String[] args) {
		//int[] arr = { 0,1,2,4,5,7,8,9,11};
		int[] arr = {1,3,5,6,7};
		// System.out.println(
		System.out.println(ranges(arr));// );
	}

	public static List<String> ranges(int[] arr) {
		List<String> ranges = new ArrayList<String>();
		if(arr == null || arr.length<1){
			return ranges; 
		}else if(arr != null && arr.length == 1){
			ranges.add(arr[0]+"");
			return ranges;
		}
		int previous = arr[0];
		int start = previous;
		for (int i = 1; i < arr.length; i++) {
			if(i+1 == arr.length){
				if(previous+1 == arr[i]){
					ranges.add(start+"->"+arr[i]);
				}else{
					if(start<previous){
						ranges.add(start+"->"+previous);
					}else{
						ranges.add(start+"");
					}
					ranges.add(arr[i]+"");	
				}
			}else if(previous+1 == arr[i]){
				previous = arr[i];
			}else{
				if(start<previous){
					ranges.add(start+"->"+previous);
				}else{
					ranges.add(start+"");
				}
				
				start = arr[i];
				previous = arr[i];
			}
			
		}
		return ranges;
	}
}
