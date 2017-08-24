package com.daya.algos;

public class RemoveZeros {
	public static void main(String[] args) {
		int[] arr = {1,0,0,0,0,4,4,4,4,4,4,-959151711};
		int length = arr.length;
		for(int i=0;i<length;i++){
			if(arr[i]==0){
				for(int j=i+1;j<length;j++){
					if(arr[j]!=0){
						arr[i] = arr[j];
						arr[j] = 0;
						break;
					}
				}
			}
			
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
		//System.out.println(length);
	}

}
