package com.daya.algos;

public class RemoveElements {
	public static void main(String[] args) {
		int a[] = { 2, 2, 2, 3, 3,3 };
		// int a[] = {236,234};
		System.out.println(removeElement(a, 3));
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static int removeElement(int[] nums, int val) {
		int start = 0;
		for (int i = 0; i < nums.length; ) {
			
			if(nums[i] == val){
				i++;
			}else if(nums[i] != val && start != i){
				swap(nums,start,i);
				i = ++start;
			}else{
				start++;i++;
			}
		}
		return start;
	}

	private static void swap(int[] arr, int i, int j) {
		arr[i] += arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}
}
