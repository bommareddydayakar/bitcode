package com.equinix.algos.dynamicprog;

public class LinearEquationCombinations {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 5 };
		int rhs = 1000;
		System.out.println(
				"Number of ways linear equation can be solved with coefficients are:" + coeff(arr, rhs, arr.length));

		int[][] dict = new int[rhs + 1][arr.length + 1];
		for (int i = 0; i < dict.length; i++) {
			for (int j = 0; j < dict[i].length; j++) {
				dict[i][j] = -1;
			}
		}
		System.out.println("Number of ways linear equation can be solved with coefficients are:"+ coeffDPMem(arr, rhs, arr.length, dict));
		System.out.println("Number of ways linear equation can be solved with coefficients are:"+ coeffDPTab(arr, rhs, arr.length));
		

	}

	private static int coeff(int[] arr, int rhs, int length) {
		if (length <= 0 || rhs < 0) {
			return 0;
		}
		if (rhs == 0)
			return 1;

		return coeff(arr, rhs - arr[length - 1], length) + coeff(arr, rhs, length - 1);
	}

	private static int coeffDPMem(int[] arr, int rhs, int length, int[][] dict) {

		if (length <= 0 || rhs < 0) {
			return 0;
		}
		if (dict[rhs][length] != -1)
			return dict[rhs][length];

		else if (rhs == 0) {
			dict[rhs][length] = 1;
		} else {
			dict[rhs][length] = coeffDPMem(arr, rhs - arr[length - 1], length, dict)
					+ coeffDPMem(arr, rhs, length - 1, dict);
		}
		return dict[rhs][length];
	}

	private static int coeffDPTab(int[] arr, int rhs, int length) {
		int[][] dict = new int[rhs+1][length+1];
		
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < dict[i].length; j++) {
				dict[i][j] = 1;
			}
		}
		
/*		for (int i = 0; i < dict.length; i++) {
			for (int j = 0; j < 1; j++) {
				dict[i][j] = 1;
			}
		}
*/		
		
		for (int i = 1; i < dict.length; i++) {
			for (int j = 1; j < dict[i].length; j++) {
				dict[i][j] = dict[i-1][j]+dict[i][j-1];
			}
		}
		
		
		return dict[rhs][length];
	}

}











































