package com.equinix.algos.dynamicprog;

public class KnapSack {
	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120,140};
        int w[] = new int[]{10, 20, 10,20};
		int W = 50;
		int[][] res = new int[val.length+1][W+1]; 
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				res[i][j] = -1;
			}
		}
		System.out.println("Knapsack greatest value is:"+knapSackDP(val,w,W,val.length,res));
		System.out.println("asfasf");
		
	}

	private static int knapSackRec(int[] val, int[] w, int W,int vLen) {
		int max = Integer.MIN_VALUE;
		if(W <= 0 || vLen <= 0)
			return 0;  
		if(w[vLen-1] > W)
			return knapSackRec(val,w,W,vLen-1);
		else
			return Math.max(knapSackRec(val,w,W,vLen-1),val[vLen-1]+ knapSackRec(val,w,W-w[vLen-1],vLen-1)); 
	}
	private static int knapSackDP(int[] val, int[] w, int W,int vLen,int[][] res) {
		if(res[vLen][W] > -1)
			return res[vLen][W];
		if(W <= 0 || vLen <= 0)
			return 0;
		if(w[vLen-1] > W)
			return knapSackRec(val,w,W,vLen-1);
		else
		{
			res[vLen][W]	= Math.max(knapSackDP(val,w,W,vLen-1,res),val[vLen-1]+ knapSackDP(val,w,W-w[vLen-1],vLen-1,res));	
			return res[vLen][W]; 
		}
	}
}
