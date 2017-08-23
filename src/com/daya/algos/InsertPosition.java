package com.equinix.algos;

public class InsertPosition {
	public static void main(String[] args) {
		int a[] = {1,3,5,6};
		System.out.println(insertPosition(a,6));
	}
	
	public static int insertPosition(int[] a,int tar){
		if(a == null || a.length  == 0)
			return 0;
		else if(tar <= a[0])
			return 0;
		else if(tar > a[a.length-1])
			return a.length;
		else if(tar == a[a.length-1])
			return a.length-1;
		
		
		int length = a.length;
		int start = 0, end = length-1;
		int half = length/2;
		
		while(start>-1 && end < length){
			
			if(tar < a[half] ){
				end = half;
			}else if(tar > a[half]){
				start = half;
			}else if(tar == a[half]){
				return half;
			}
			if(start+1 == end){
				return end;
			}
			half = (start+end) /2;
				
		}
		
		return -1;
		
		
	}
}
