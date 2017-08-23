package com.equinix.algos;

public class QuickSort {
	public static void main(String[] args) {
		int a[] = {1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4};//{100,234,2,234,23,634,12,0,-1,-101};
		//int a[] = {236,234};
		quickSort(a,0,a.length-1);
		for (int i : a) {
			System.out.println(i);
		}
		
	}
	
	public static void quickSort(int[] arr,int start,int end){
		if(arr == null || arr.length ==0)
			return;
		else{
			if(start<end){
				int partition = partition(arr,start,end);
				//System.out.println(partition);
				quickSort(arr,start,partition-1);
				quickSort(arr,partition+1,end);
			}
		}
	}
	public static int partition(int[] arr, int start,int end){
		int x = arr[end];
		int i = start-1;
		for(int j=start;j<end;j++){
			if(arr[j] <= x){
				i++;
				if(i!=j)
					swap(arr,i,j);
			}
		}
		swap(arr,i+1,end);
		
		return i+1;
	}
	
	public static void swap(int[] arr, int src,int tgt){
		if(src==tgt)
			return;
		arr[src] = arr[src] + arr[tgt];
		arr[tgt] = arr[src]-arr[tgt];
		arr[src] = arr[src]-arr[tgt];
		//System.out.println(arr[src]+":"+arr[tgt]);
	}
}
