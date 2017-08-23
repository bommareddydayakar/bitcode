package com.equinix.algos;

public class MedianTwoSortedArrays {
	public static void main(String args[]){
		//int a[] = {10, 12, 15, 26, 38,40};
	    //int b[] = {41, 85, 88, 99, 100};
		//int b[] = {1,2,3,4,5};
		int a[] = {1};
		int b[] = {2,3,4};
		double median = median(a,b);
		System.out.println(median);
	}
	private static double median(int[] a,int[] b){
		
		int percentile = ((a.length+b.length)%2);
		int medianItem = ((a.length+b.length)/2);
		int totalLen = a.length + b.length;
		
		int[] big, small;
		if(a.length > b.length){
			big = a;small = b;
		}else{
			big = b; small = a;
		}
		if(totalLen > 0 ){
			if(small == null || small.length == 0){
				if(percentile == 0){
					return ((double)big[medianItem]+(double)big[medianItem-1])/2;
				}else{
					return (big[medianItem]);
				}
			}	
		}else
			return 0.0;
		
		if(percentile ==0)
			medianItem--;
		
		int index = 1,i=medianItem,j=0;
		while(j < index && i>-1 && j > -1){
			if(i> -1 && j<small.length && big[i] > small[j] ){
				if(j+1 < index){
					j++;
				}else{
					j=0;
					i--;
					index++;
				}
			}else{
				i++;
				index--;
				break;
			}
		}
		
		i--;
		System.out.println(i+":"+index);
		if(percentile != 0){
			if(index ==0){
				return big[i];
			}
			if(big[i]>small[index-1]){
				return big[i];
			}else{
				return small[index-1];
			}
		}else{
			if(i<0)i=0;
			if(index>=small.length)
				index = small.length-1;
			
			return (double)(big[i]+small[index])/2;
		}
	
	}
}
