package com.equinix.algos.dynamicprog;

public class SnakeMatrix {
	public static void main(String[] args) {
		int[][] mat =
		    {
		        {9, 6, 5, 2},
		        {8, 7, 6, 5},
		        {7, 6, 5, 6},
		        {2, 3, 4, 7},
		    };
		
		System.out.println("Snake path follows below"+snakePath(mat));
		
	}

	private static String snakePath(int[][] mat) {
		
		int[][] dict = new int[mat.length+1][mat[0].length+1];
		for (int i = 0; i < dict.length; i++) {
			for (int j = 0; j < dict[i].length; j++) {
				dict[i][j] = 1;
			}
		}
		int max = Integer.MIN_VALUE;
		int maxI = -1,maxJ = -1; 
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if( j+1 < mat[i].length && Math.abs(mat[i][j]-mat[i][j+1]) == 1 && dict[i+1][j+1]+1 > dict[i+1][j+2]){
					dict[i+1][j+2] = dict[i+1][j+1]+1;
					if(max<dict[i+1][j+2]){
						max = dict[i+1][j+2];
						maxI = i;
						maxJ = j+1;
								
					}
				}
				
				if(i+1 < mat.length &&  Math.abs(mat[i][j]-mat[i+1][j]) == 1 && dict[i+1][j+1]+1 > dict[i+2][j+1]){
					dict[i+2][j+1] = dict[i+1][j+1]+1;
					if(max<dict[i+2][j+1]){
						max = dict[i+2][j+1];
						maxI = i+1;
						maxJ = j;
								
					}
				}
				
			}
		}
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]+"      ");
			}
			System.out.println();
			
		}
		System.out.println("--------------------------------"+max+":"+maxI+":"+maxJ);
		for (int i = 0; i < dict.length; i++) {
			for (int j = 0; j < dict[i].length; j++) {
				System.out.print(dict[i][j]+"      ");
			}
			System.out.println();
			
		}
		for (; maxI > -1; ) {
			for (; maxJ>-1;){
				System.out.println(mat[maxI][maxJ]);
				if(Math.abs(dict[maxI][maxJ+1]-dict[maxI+1][maxJ+1]) == 1 && Math.abs(mat[maxI-1][maxJ]-mat[maxI][maxJ]) == 1 ){
					maxI--;
				}
				else if(Math.abs(dict[maxI+1][maxJ]-dict[maxI][maxJ]) == 1 && Math.abs(mat[maxI][maxJ-1]-mat[maxI][maxJ]) == 1 ){
					maxJ--;
				}
				
			}
		}
		
		return null;
	}
	
}
