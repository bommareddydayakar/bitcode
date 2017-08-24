package com.daya.backtrack;

public class NightsTour {
	private static int glcnt = 0;
	public static void main(String[] args) {
		int[] mvRows = {1,  1, -1, -1, 2,  2, -2, -2};
		int[] mvCols = {2, -2,  2, -2, 1, -1, -1, 1};
		int N = 6;
		int count=1;
		int[][] res = new int[N][N];
		res[5][5] = 1;

		nightsTour(res, mvRows, mvCols, 5, 5, N, count);
		if(glcnt == 0)
			System.out.println("Solutions is not possible!");
		else
			System.out.println(glcnt+" possibilities are there for given "+N);
	}

public static void nightsTour(int[][] res, int[] mvRows, int[] mvCols, int stRow, int stCol, int N, int count){
	for(int i=0;i<mvRows.length;i++){
		int newRow = stRow+mvRows[i];
		int newCol = stCol+mvCols[i];
		if(newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || res[newRow][newCol] > 0) {
			// Move is not allowed
			continue;
		}else{
			// it is allowed
			res[newRow][newCol] = ++count;
			if(count == N*N){
				// Nights tour is finished
				displayTour(res);
			}
			//Check further possibilities
			nightsTour(res, mvRows, mvCols, newRow, newCol, N, count);	
			if(count != N*N){
				res[newRow][newCol] = 0;
				count--;
			}			
		}
	}
	return;
}

	public static void displayTour(int[][] res) {
		System.out.println("*************************************"+ ++glcnt);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				if(res[i][j]<10)
					System.out.print(" "+res[i][j] + "-");
				else
					System.out.print(res[i][j] + "-");
			}
			System.out.println(" ");
		}
	}
}
