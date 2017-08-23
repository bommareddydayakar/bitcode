package com.equinix.algos.datastructures;

public class MinHeap {
	int[] hArray;
	int hCap;
	int hSize;
	public MinHeap(int c){
		hCap = c;
		hArray = new int[hCap];
		hSize = 0;		
	}
	public void insertKey(int key){
		if(hSize > hCap){
			System.out.println("Heap overflow");
			return;
		}
		hSize++;
		int i = hSize-1;
		hArray[i] = key;
		while(i != 0 && hArray[parent(i)] > hArray[i]){
			swap(i, parent(i));
			i = parent(i);
		}
		
		
	}
	private void swap(int i, int parent) {
		int tmp = hArray[i];
		hArray[i] = hArray[parent];
		hArray[parent] = tmp;
	}
	private int parent(int i) {
		return (i-1)/2;
	}
	private void displayHeap() {
		if(hSize == 0){
			System.out.println("Heap is empty");
		}
		for (int i = 0; i < hSize; i++) {
			System.out.println(hArray[i]);
		}
	}
	private int top(){
		if(hSize == 0){
			System.out.println("Heap is empty");
			return Integer.MAX_VALUE;
		}
		return hArray[0];
	}
	private int pop(){
		if(hSize == 0){
			System.out.println("Heap is empty");
			return Integer.MAX_VALUE;
		}
		int top = top();
		hArray[0] = hArray[hSize-1];
		hArray[hSize-1] = Integer.MAX_VALUE;
		hSize--;
		heapify();
		return hArray[hSize-1];
	}
	private int left(int curr){
		return curr*2 + 1;
	}private int right(int curr){
		return curr*2 + 2;
	}
	private void heapify() {
		
	}
	public static void main(String[] args) {
		MinHeap mHeap = new MinHeap(10);
		mHeap.insertKey(10);
		mHeap.insertKey(1);
		mHeap.insertKey(9);
		mHeap.insertKey(8);
		mHeap.insertKey(7);
		mHeap.insertKey(11);
		mHeap.displayHeap();
	}
	
	
}
