package com.daya.algos.matrices;

public class Matrix {
	int[][] matrix;

	public Matrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[2][3];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		//matrix[2][0] = 7;
		//matrix[2][1] = 8;
		//matrix[2][2] = 9;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+"   ");
			}
			System.out.println("   ");
		}
		Matrix mat = new Matrix(matrix);
		int[][] tMatrix = mat.transpose();
		for (int i = 0; i < tMatrix.length; i++) {
			for (int j = 0; j < tMatrix[i].length; j++) {
				System.out.print(tMatrix[i][j]+"   ");
			}
			System.out.println("   ");
		}

	}

	public int[][] transpose() {
		if (this.matrix != null && matrix.length > 0) {
			int columns = matrix.length;
			int rows = 0;
			for (int i = 0; i < matrix.length; i++) {
				rows = Math.max(matrix[i].length, rows);
			}
			int[][] tMatrix = new int[rows][columns];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					tMatrix[j][i] = matrix[i][j];
				}
			}
			return tMatrix;
		}
		return null;
	}

}
