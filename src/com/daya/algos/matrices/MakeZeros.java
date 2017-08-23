package com.equinix.algos.matrices;

import java.util.ArrayList;
import java.util.List;

public class MakeZeros {
	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0 } 
					};
		int rows = 3, cols = 4;

		List<Integer> processedRows = new ArrayList<Integer>();
		List<Integer> processedCols = new ArrayList<Integer>();
		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
		makeZeros(arr, 0, 0, rows, cols, processedRows, processedCols);
		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}

	private static void makeZeros(int[][] arr, int i, int j, int rows, int cols, List<Integer> processedRows,
			List<Integer> processedCols) {
		if (i >= rows)
			return;
		if (j >= cols)
			i++;

		int originalJ = j; 
		for (int newI = i; newI < rows; newI++) {
			for (int newJ = originalJ; newJ < cols; newJ++) {
				if (arr[newI][newJ] == 0) {
					makeZeros(arr, newI, newJ + 1, rows, cols, processedRows, processedCols);
					System.out.println("************");
					if (!processedRows.contains(newI)) {
						int extraJ = cols - 1;
						for (; extraJ > -1; extraJ--){
							arr[newI][extraJ] = 0;
						}
						processedRows.add(newI);
					} else {
						System.out.println(newI + " row skipped as already processed");
					}

					if (!processedCols.contains(newJ)) {
						int extraI = rows - 1;
						for (; extraI > -1; extraI--){
							arr[extraI][newJ] = 0;
						}
						processedCols.add(newJ);
					} else {
						System.out.println(newJ + " Col skipped as already processed");
					}
					return;
				}
				if (newJ + 1 == cols)
					originalJ = 0;
			}
		}
	}
}
