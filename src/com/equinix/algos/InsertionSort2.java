package com.equinix.algos;

public class InsertionSort2 {
	public static void main(String[] args) {
		int a[] = {100,234,2,234,23,634,12,0,-1,-101};
		//int a[] = {236,234};
		selectionSort(a);
	}
	
	public static void selectionSort(int[] arr){
		if(arr == null || arr.length ==0)
			System.out.println("Array needs to be populaed to sort.");
		else{
		
			for(int j=1;j<arr.length;j++){
				int key = arr[j];
				int i=j-1;
				while(i>-1 && arr[i] > key){
					arr[i+1] = arr[i];
					i--;
				}
				arr[i+1] = key;
			}
			
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		}
	}
}
