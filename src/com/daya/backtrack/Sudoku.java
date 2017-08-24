package com.daya.backtrack;

public class Sudoku {
	public static void main(String[] args) {
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		int status[][] = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] <= 0)
					status[i][j] = -1;
				else {
					count++;
				}
			}
		}

		if (solveSudoku(grid)) {
			displayGrid(grid);
		} else {
			System.out.println("Sudoku Cannot be solved!");
			displayGrid(grid);
		}

	}

	static int count = 0;

	public static boolean solveSudoku(int[][] grid) {
		
		int[] coords = new int[2];
		if(findNextPosition(grid, coords)){
			int row = coords[0];
			int col = coords[1];
			for (int i = 1; i <= 9; i++) {
				if(isSafeToPut(grid, row, col, i)){
					grid[row][col] = i;
					if(solveSudoku(grid)){
						return true;
					}else{
						grid[row][col] = 0;
					}
				}
			}
		}else{
			return true;
		}
		return false;
	}

	private static void displayGrid(int[][] grid) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	public static boolean findNextPosition(int[][] grid, int[] coords) {
		
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0) {
					coords[0]= i;
					coords[1]= j;
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isSafeToPut(int[][] grid, int i, int j, int num) {
		for (int k = 0; k < 9; k++) {
			if (k != j && grid[i][k] == num)
				return false;
		}
		for (int k = 0; k < 9; k++) {
			if (k != i && grid[k][j] == num)
				return false;
		}
		int inGridRowSt = (i / 3) * 3;
		int inGridColSt = (j / 3) * 3;
		
		for (int k = inGridRowSt; k < inGridRowSt + 3; k++) {
			for (int m = inGridColSt; m < inGridColSt + 3; m++) {
				if (grid[k][m] == num)
					return false;
			}
		}
		return true;
	}

	
}
