package com.daya.algos;

public class HeapSort {
	
	static int[] a = {100,234,2,234,23,634,12,0,-1,-101};
	
	public static void main(String[] args) {
		if(a != null && a.length > 0){
			for(int i=a.length/2;i>-1;i--){
				maxHeapify(i);
			}
		}
		for (int i : a) {
			System.out.println(i);
		}
		increaseKey(3, 305);
		System.out.println("*******************");
		for (int i : a) {
			System.out.println(i);
		}
		
		
	}
	public static void maxHeapify(int index){ 
		if(a != null && a.length > 0){
			int left = (index*2)+1;
			int right = (index*2)+2;
			int largest = index;
			if(left < a.length && a[left] > a[index]){
				largest = left;
			}else{
				largest = index;
			}
			
			if(right< a.length && a[right] > a[largest]){
				largest = right;
			}
			if(largest != index){
				swap(index,largest);
				maxHeapify(largest);
			}
		}
	}
	public static Integer extractMax(){
		if(a == null || a.length <1){
			System.out.println("UNDERFLOW");
			return null;
		}else{
			int max = a[0];
			a[0] = a[a.length-1];
			int[] tmp = a;
			a = new int[tmp.length-1];
			for (int i=0;i<tmp.length-1; i++) {
				a[i] = tmp[i];
			}
			maxHeapify(0);
			return max;
		}
		
	}
	public static void increaseKey(int index, int key){
		if(a[index] > key){
			System.out.println("Not allowed");
			return;
		}
		a[index] = key;
		while(index>0){
			int parent = parent(index);
			if(a[index]>a[parent]){
				swap(index,parent);
			}
			index = parent;
			
		}
		
	}
	public static int parent(int i){
		if(i%2 ==0){
			return (i/2)-1;
		}
		return i/2;
	}
	
	public static void swap(int src,int tgt){
		if(src==tgt)
			return;
		a[src] = a[src] + a[tgt];
		a[tgt] = a[src]-a[tgt];
		a[src] = a[src]-a[tgt];
		//System.out.println(arr[src]+":"+arr[tgt]);
	}
}
