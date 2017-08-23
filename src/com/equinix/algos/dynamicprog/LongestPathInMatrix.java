package com.equinix.algos.dynamicprog;

public class LongestPathInMatrix {
	public static void main(String[] args) {
		int[][] mat = {
					{4, 3},
					{1, 2}
				};
				
		/*
		 * 		{1, 2, 7},
				{2, 3, 6},
				{3, 4, 5}};
				
				
				{10, 9, 8},
				{5, 6, 7},
				{4, 3, 2}};
		
		 * 
		 */
		
		System.out.println("The longest path in the given Matrix is:"+longestPathDP(mat));
	}

	private static int longestPathDP(int[][] mat) {
		
		int[][] lpMat = new int[mat.length][mat[0].length];
		
		//Atleast path for each value is 1.
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++){
				lpMat[i][j] = 1;
			}
		}
		
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++){
				
			}
		}
		int max = 0 ;
		for (int[] is : lpMat) {
			for (int i : is) {
				max = Math.max(max, i);
			}
		}
		
		return max;
	}
	private static int longestPathRec(int[][] mat) {
		int result = 0;
		
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++){
				result = Math.max(result,findPathLength(mat,i,j));
			}
		}
		
		return result;
	}

	
	private static int findPathLength(int[][] mat, int i, int j) {
		if(i<0 || i>=mat.length || j<0 || j>=mat[i].length)
			return 0;
		
		if(i>0 && mat[i-1][j] == mat[i][j]+1)
			return 1+ findPathLength(mat,i-1,j);
		if(i<mat.length-1 && mat[i+1][j] == mat[i][j]+1)
			return 1+ findPathLength(mat,i+1,j);
		if(j > 0 && mat[i][j-1] == mat[i][j]+1)
			return 1+ findPathLength(mat,i,j-1);
		if(j<mat[i].length-1 && mat[i][j+1] == mat[i][j]+1)
			return 1+ findPathLength(mat,i,j+1);
		
		return 1;
	}
}
