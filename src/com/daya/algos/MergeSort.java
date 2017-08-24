package com.daya.algos;

public class MergeSort {
	public static void main(String args[]){
		//int[] src = {5,3,2,1};
		int[] src = {5,3,0,9,5,3,2,1,5,3,2,1,5,3,2,1};
		int[] target = new int[src.length];
		for (int i=0;i<src.length;i++) {
			target[i] = src[i];
		}
		split(src,0,src.length,target);
		System.out.println(target);
		for (int i : target) {
			System.out.println(i);
		}
	}
	private static void split(int[] AA,int start, int end, int[] BB){
		if(end-start <2){
			return;
		}
		int middle = (end+start)/2;
		split(BB,start,middle,AA);
		split(BB,middle,end,AA);
		merge(AA, middle, start, end, BB);
	}
	private static void merge(int src[],int middle, int start, int end, int[] target){
		int j = middle;
		int i = start;	
		for(int tmp = start;tmp<end;tmp++){
			if(i<middle && (j>=end || src[i] <= src[j])){
				//swap(target,tmp,i);
				target[tmp] = src[i];
				i++;
			}else{
				//swap(target,tmp,j);
				target[tmp] = src[j];
				j++;
			}
		}
		
	}
	
}
