package com.equinix.algos.backtrack;

public class NQueens {
	private static int limit;
	public static void main(String[] args) {
		int N = 12;
		limit = 1<<N;
		System.out.println(limit);
		char[][] res = new char[N][N];
		int countOfQueens = 0;
		int stRow = 0;
		long curr1=System.currentTimeMillis();
		nQueens(0, N, 0, new int[N], new int[N], 0, new char[N][N]);
		curr1 = System.currentTimeMillis()-curr1;
		
		
		long curr2=System.currentTimeMillis();
		nQueens(stRow, N, res, countOfQueens);
		curr2 = System.currentTimeMillis()-curr2;
		
		System.out.println(curr1+"End of the program"+curr2);
		
	}

	
	private static void nQueens(int stRow, int N, int colTracker, int[] ld, int[] rd, int countOfQueens,char[][] mat) {
		if(stRow >= N)
			return;
		for (int i = stRow; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				//Column testing
				int tmp = colTracker & (1 << (N - j));
				if(tmp > 0){
					// Queen is set in this column. No more Queens are allowed
					continue;
				}
				// Left Diagonal Testing
				if(    (ld[i]& (1<< (N-j)))  > 0){
					continue;
				}
				
				// Right Diagonal Testing
				if(    (rd[i] & (1<< (N-j)))  > 0){
					continue;
				}
				
				
				
				//On current j bit in colTracker
				colTracker = colTracker | (1 << (N-j));
				
				// Update all left diagonals
				int rows = i;
				int cols = j;
				while(rows < N && cols < N ){
					ld[rows] |= (1<< (N-cols));
					cols++;
					rows++;		
				}
				
				// Update all right diagonal
				rows = i;
				cols = j;
				while(rows < N && cols > -1 ){
					rd[rows] |= (1<< (N-cols));
					cols--;rows++;		
				}
				countOfQueens++;
				mat[i][j] = 'x';
				if(countOfQueens == N)
					displayResults(mat);
				nQueens(i+1, N, colTracker, ld, rd, countOfQueens,mat);
				
				// backtrack code
				countOfQueens--;
				mat[i][j] = ' ';
				
				//Off current j bit in colTracker
				colTracker = colTracker & ~(1 << (N-j));
				
				// Update all left diagonals
				rows = i;
				cols = j;
				while(rows < N && cols < N ){
					ld[rows] &= ~(1<< (N-cols));
					cols++;
					rows++;		
				}
				
				
				// Update all right diagonal
				rows = i;
				cols = j;
				while(rows < N && cols > -1 ){
					rd[rows] &= ~(1<< (N-cols));
					cols--;rows++;		
				}
			}
		}
	}
	
	private static void nQueens(int stRow, int N, char[][] res, int countOfQueens) {
		
		if(stRow >= N)
			return;
		for (int i = stRow; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// x: self occupied
				// y: column occupied
				if(res[0][j] == 'x' || res[0][j] == 'y'){
					// Ignore case
					continue;
				}else if(res[0][j] != 'x' && res[0][j] != 'y') {
					// this column is not occupied by any other queen
					// Check diagonally
					boolean flag = true;
					
					int newI = i-1, newJ = j-1;
					while(newI >=0  && newJ>=0){
						if(res[newI][newJ] == 'x'){
							flag = false;
						}
						newI--;newJ--;
					}
					newI = i-1;
					newJ = j+1;
					while(newI >=0  && newJ<N){
						if(res[newI][newJ] == 'x'){
							flag = false;
						}
						newI--;newJ++;
					}
					if(flag){
						res[0][j] = 'y';
						res[i][j] = 'x';
						countOfQueens++;
						if(countOfQueens == N){
							displayResults(res);
							//return; for one succesful case enable this line
						}
						
						//Current row queen is selected. process further rows.
						nQueens(i+1, N, res, countOfQueens);
						//Backtrack code
						flag = false;
						res[i][j] = ' ';
						res[0][j] = ' ';
						countOfQueens--;
						
					}					
				}
			}
		}
	}
	static int count =0;
	private static void displayResults(char[][] res) {
		System.out.println("*********************************************"+ ++count);
		if(res != null && res.length > 0){
			for (char[] cs : res) {
				for (char c : cs) {
					if(c == 'x')
						System.out.print(c+" ");
					else
						System.out.print("- ");
				}
				System.out.println(" ");
			}
		}
		
	}
}
