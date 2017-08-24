package com.daya.algos.dynamicprog;

public class MatrixPathsNXM {
	public static void main(String[] args) {
		System.out.println("Number of paths in 3X3 matrix are: "+numberOfPaths(3,2));
	}

	private static int numberOfPaths(int i, int j) {
		int dict[][] = new int[i+1][j+1];
		dict[1][1] = 1; // There must be one way to reach first element.
		for (int k = 1; k <= i; k++) {
			for (int m = 1; m <= j; m++) {
				if(k== 1 && m==1)
					continue;
				dict[k][m] = dict[k-1][m]+dict[k][m-1];
			}
		}
		
		return dict[i][j];
	}
}
