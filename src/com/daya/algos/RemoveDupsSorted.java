package com.daya.algos;

public class RemoveDupsSorted {
	public static void main(String[] args) {
		int[] arr = {1,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,6};
		int length = arr.length;
		for(int i=0;i<length;i++){
			int j=i+1;
			boolean dupFound = false;
			while(j<length){
				if(arr[i]==arr[j])
					{
						j++;
					}
				else
					break;
			}
			j--;
			if(j>i){
				int k = i+1;
				int ne = length-(j-i);
				if(k==length){
					arr[k] = -1;
				}else{
					int diff = j-i;
					while(k<j){
						arr[k++] = -1;
					}
					while(j<length){
						arr[j-diff] = arr[j];
						arr[j++] = -1;
					}
					
				}
				length = ne;
			}
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
		System.out.println(length);
	}

}
