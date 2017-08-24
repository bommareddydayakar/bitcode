package com.daya.algos;

public class MergeSort2 {
	public static void main(String args[]){
		//int[] src = {5,3,2,1};
		int[] src = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5};
		//int[] src = {9,8,7,6};
		int middle = src.length/2;
		merge(src, 0, middle, src.length-1);
		for(int i=0;i<src.length;i++){
			System.out.println(src[i]);
		}
	}
	private static void merge(int[] src,int start, int middle, int end){
		if(src.length <=1)
			return ;
		else{
			int[] left = new int[middle-start];
			int[] right = new int[1+end-middle];
			for(int i=0;i<middle;i++){
				left[i] = src[i];
			}
			for(int j=0;j<=(end-middle);j++){
				right[j] = src[j+middle];
			}
			
			merge(left,0,left.length/2,left.length-1);
			merge(right,0,right.length/2,right.length-1);
			int i=0,j=0;
			for(int k=0;k<src.length;k++){
				//System.out.println(i+":"+j+":"+left[i]+":"+right[j]);
				if(i<left.length && (j>=right.length || left[i] <= right[j])){
					src[k] = left[i];i++;
				}else{
					src[k] = right[j];j++;
				}
			}
			
			for(int l=0;l<src.length;l++){
			//	System.out.println(src[l]);
			}
		}
	}
}
