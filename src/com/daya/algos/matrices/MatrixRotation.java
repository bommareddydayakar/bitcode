package com.daya.algos.matrices;

public class MatrixRotation {
	
	public static void main(String[] args) {
		
		int[][] arr3x3 = 
			{
				{100, 2, 3},
				{4, 5, 6},
				{7, 8, 19}				
			};
		int[][] arr4x4 = 
			{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 101, 12},
				{13, 14, 15, 160}		
				
			};
		
		
		int[][] arr2x2 = 
			{
				{1, 2},
				{4, 5}				
			};
		//System.out.println("determinanc-->"+determinant(arr3x3, 0, arr3x3.length-1, 3));
		System.out.println("determinanc-->"+determinant(arr4x4, 0, arr4x4.length-1, 4));
		
		//int[][] arr = arr2x2;int n = 2;
		int[][] arr = arr3x3;int n = 3;
		//int[][] arr = arr4x4;int n = 4;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println("  ");
		}
		
		System.out.println("<---------------------------------------------------->");
		//rotateMatrix(arr,n-1,0,n-1);
		rotateMatrixAntiClock(arr,n);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println("  ");
		}
		
		System.out.println("<---------------------------------------------------->");
		//rotateMatrix(arr,n-1,0,n-1);
		rotateMatrixClock(arr,n);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println("  ");
		}
	}
	
	private static int determinant(int[][] arr, int start, int end, int limit){
		if(limit == 2)
			return arr[start][start] * arr[end][end] - arr[start][end] * arr[end][start] ;
		int[][] tmp = new int[limit-1][limit-1];
		int k =0;
		int l=0;
		int skip = 0;
		int det = 0;
		while(skip<limit) {
			for (int i = 1; i < limit; i++) {
				for (int j = 0; j < limit; j++) {
					if(j==skip)
						continue;
					tmp[k][l++] = arr[i][j];
				}
				k++;
				l=0;
			}
			if(skip%2 == 0)
				det += arr[0][skip]*determinant(tmp, 0, tmp.length-1, tmp.length);
			else
				det -= arr[0][skip]*determinant(tmp, 0, tmp.length-1, tmp.length);
			skip++;
			k=0;
			l=0;
		}
		
		return det;
		
	}
	private static void rotateMatrixAntiClock(int[][] arr, int max) {
		if(arr == null || arr.length == 0)
			return;
		for (int i = 0; i < max/2; i++) {
			for (int j = i; j < max-i-1; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[j][max-i-1];
				arr[j][max-i-1] = arr[max-i-1][max-j-1];
				arr[max-i-1][max-j-1] = arr[max-j-1][i];
				arr[max-j-1][i] = tmp;
			}
		}
	}
	private static void rotateMatrixClock(int[][] arr, int max) {
		if(arr == null || arr.length == 0)
			return;
		for (int i = 0; i < max/2; i++) {
			for (int j = i; j < max-i-1; j++) {
				
				int tmp = arr[i][j];
				arr[i][j] = arr[max-j-1][i]; 
				arr[max-j-1][i] = arr[max-i-1][max-j-1];
				arr[max-i-1][max-j-1] = arr[j][max-i-1];
				arr[j][max-i-1] = tmp;
				
			}
		}
	}

	
	/*{
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9}				
	};*/
	private static void rotateMatrix(int[][] arr, int n, int start, int end) {
		System.out.println("********************************");
		int cycle = 0; // 1
		int max = end; // 2
		int nn = max-cycle; //1
		while((start+cycle)<max){ 
			int i=start; //1
			int j=start+cycle; //1
			int tmp = arr[i][j]; //6
			while(true){
				if(i<nn && j==start+cycle){ // i=0 j=0
					i= nn;
					j = start+(max-nn-cycle);
				}else if(i==nn && j<=(start+cycle)){
					i = nn+cycle;
					j = nn;
				}else if(i >= nn && j == nn){
					i = start+cycle;
					j = nn+cycle;
				}
				else if(i<=(start+cycle) && j>=nn){
					j = start+cycle;
					i = start;
				}
				int newTmp = arr[i][j];
				arr[i][j] = tmp;
				tmp = newTmp;
				System.out.println(i+":"+j);
				if(i== start && j == (start+cycle))
					break;
				
			}
			cycle++;
			nn = max-cycle;
		}
		if(start<n){
			rotateMatrix(arr, n,++start,end-1); // arr, 3, 1,2
		}
	}
	
	
	
	
}
