package com.equinix.algos;

public class ContainerMostWaters {
	public static void main(String[] args) {
		int[] arr = { 1,2,4,3};
		System.out.println(maxArea(arr));
	}

	public static int maxArea(int[] arr) {
		int max =0;
		int left = 0, right = arr.length-1;
		while(left<right){
			int tMax = 0 , tLR = 0 ;
			if(arr[left]>arr[right]){
				tLR = arr[right];					
			}else if(arr[left]<arr[right] || arr[left] == arr[right] ){
				tLR = arr[left];					
			}
			tMax = (right - left) * tLR;
			if(max<tMax){
				max = tMax;
			}
			
			if(arr[left]>arr[right]){
				right--;
			}else{
				right--;
			}
		}
		return max;
	}
}
