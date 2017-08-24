package com.daya.algos.dynamicprog;

public class CosttoFillBag {
	public static void main(String[] args) {
		int W = 5;
		int[] arr = {-1, 2, 3, 4, 5};
		System.out.println("Min Cost of filling the bag with given weight capacity "+W+" is:"+cost(arr,W,arr.length));
	}

	private static int cost(int[] arr, int w, int len) {
		while(len > 0 && arr[len-1] == -1){
			len--;
		}
		if(w == 0 && len > 0)
			return 0;
		
		if(len > w)
			return cost(arr,w,len-1);
		
		if(w < 0 || len <= 0 )
			return Integer.MAX_VALUE;
		
		
		return Math.min(arr[len-1]+cost(arr,w-len,len) , cost(arr,w,len-1));
	}

}
