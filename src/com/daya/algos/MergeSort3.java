package com.daya.algos;

public class MergeSort3 {
	public static void main(String args[]){
		//int[] src = {5,3,2,1};
		//int[] src = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5};
		int[] src = {14, 7, 3, 12, 9, 11, 6, 2};
		//int middle = src.length/2;
		merge(src, 0, src.length-1);
		for(int i=0;i<src.length;i++){
			System.out.println(src[i]);
		}
	}
	private static void merge(int[] src,int start, int end){
		int middle = (start+end)/2;
		if(start >= end){
			return;
		}else{
			merge(src,start,middle);
			merge(src,middle+1,end);
			int j = middle+1;
			int[] tmp = new int[end+1-start];
			int st = start,index = st;
			
			for (int i = 0; i < tmp.length; i++) {
				
				if(start <= middle && j<= end && src[start]> src[j]){
					tmp[i] = src[j];
					j++;
				}else if(start<=middle){
					tmp[i] = src[start++];
					
				}else {
					tmp[i] = src[j++];
				}
			}
			
			
			for (int i : tmp) {
				src[index++] = i;
			}
		}
		
	}
}

