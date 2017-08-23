package com.equinix.algos.dynamicprog;

public class MinCostPath {
	public static void main(String[] args) {
		int cost[][] = { 
				{1, 2, 3},
	            {4, 8, 2},
	            {1, 5, 3} 
			};
		System.out.println("Min Cost of the matrix is: "+minCostPath(cost,1,0));
		System.out.println("Min Cost of the matrix is: "+minCostPathTabluation(cost,2,1));
		
	}

	private static int minCostPath(int[][] cost, int r, int c) {
		if(r<0 || c<0 || r >= cost.length || c >= cost[r].length)
			return Integer.MAX_VALUE;
		if(r==0 && c==0)
			return cost[r][c];
		
		return cost[r][c] + 
				Math.min(minCostPath(cost,r-1,c-1), Math.min(minCostPath(cost,r-1,c),minCostPath(cost,r,c-1)));
	}
	
	private static int minCostPathTabluation(int[][] cost, int r, int c) {
		int[][] dict = new int[cost.length+1][cost[0].length+1];
		for (int i = 0; i < dict.length; i++) {
			for (int j = 0; j < dict[i].length; j++) {
				dict[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 1; i < dict.length; i++) {
			for (int j = 1; j < dict[i].length; j++) {
				if(i == 1 && j == 1){
					dict[i][j] = cost[i-1][j-1];
				}else{
					dict[i][j] = cost[i-1][j-1]+Math.min(dict[i-1][j-1], Math.min(dict[i-1][j], dict[i][j-1]));
				}
			}
		}
		return dict[r+1][c+1];
	}
	
	
	
}
