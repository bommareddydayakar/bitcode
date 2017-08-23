package com.equinix.algos;

public class InsertionSort {
	public static void main(String[] args) {
		int a[] = {100,234,2,234,23,634,12,0,-1,-101};
		//int a[] = {236,234};
		selectionSort(a);
	}
	
	public static void selectionSort(int[] arr){
		if(arr == null || arr.length ==0)
			System.out.println("Array needs to be populaed to sort.");
		else{
			for(int i=0;i<arr.length;i++){
				int myIndex = i;
				for (int j = i+1; j < arr.length; j++) {
					if(arr[myIndex]>arr[j]){
						myIndex = j;
					}
				}
				if(i != myIndex ) 
					swap(arr,i,myIndex);
			}
			
			
			
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		}
	}
	private static void swap(int[] arr,int i,int j){
			arr[i] += arr[j];
			arr[j] = arr[i]-arr[j];
			arr[i] = arr[i]-arr[j];
	}
}
