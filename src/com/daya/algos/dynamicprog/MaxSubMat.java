package com.daya.algos.dynamicprog;

public class MaxSubMat {
	public static void main(String[] args) {
		
		int mat[][] =  {
						{0, 1, 1, 0, 1}, 
		                {1, 1, 0, 1, 0}, 
		                {0, 1, 1, 1, 0},
		                {1, 1, 1, 1, 0},
		                {1, 1, 1, 1, 1},
		                {0, 0, 0, 0, 0}
               		};
		
		System.out.println("Print Maximum Square Matrix which have maximum number of 1"+maxSquareMat(mat));
	}

	private static String maxSquareMat(int[][] mat) {
		int[][] res = new int[mat.length][mat[0].length];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 1; j++) {
				res[i][j] = mat[i][j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		int iVal = -1, jVal = -1;
		
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[i].length; j++) {
				if(mat[i][j] == 1){
					res[i][j] = Math.min(res[i-1][j-1], Math.min(res[i-1][j], res[i][j-1]))+1;
					if(max<res[i][j]){
						max = res[i][j];
						iVal = i;
						jVal = j;
					}
				}else{
					res[i][j] = 0;
				}
			}
		}
		System.out.println(max+":"+iVal+":"+jVal);
		for (int i = iVal; i > iVal-max; i--) {
			for (int j = jVal; j > jVal-max; j--) {
				System.out.print(mat[i][j]+"   ");
			}
			System.out.println(" ");
		}
		
		
		return null;
	}
	
}
