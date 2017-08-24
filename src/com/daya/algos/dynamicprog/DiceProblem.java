package com.daya.algos.dynamicprog;

public class DiceProblem {
	public static void main(String[] args) {
		int m = 6;
		int n = 3;
		int total = 8;
		int[][] res = new int[n+1][total+1];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				res[i][j]  = -1;
			}
		}
		
		System.out.println("Dice Sum Is(REC):"+diceSum(m,n,total,res));
		System.out.println("Dice Sum Is(DP-Mem):"+diceSum(m,n,total,res));
		System.out.println("Dice Sum Is(DP-TAB):"+diceSumTab(m,n,total));
		
		System.out.println("asfasf");
	}
	private static int diceSum(int m, int n, int total,int[][] res) {
		if(n >= 0 && total >= 0 && res[n][total] != -1){
			return res[n][total];
		}
		if(total == 1 && n <= total)
			res[n][total] = 1;
		else if(n<=0 || total <= 0)
			return 0;
		else{
			int sum = 0;
			for(int i=1;i<=m;i++){
				sum += diceSum(m,n-1,total-i,res);
			}
			res[n][total] = sum;
		}
		return res[n][total];
	}
	
	private static int diceSumTab(int m, int n, int total) {
		int[][] res = new int[n+1][total+1];
		for (int i = 1; i <= m && i<total; i++) {
			res[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= total; j++) {
				for (int k = 1; k <= m && k < j; k++) {
					res[i][j] += res[i-1][j-k];
				}
			}
		}
		
		
		
		return res[n][total];
	}
	
	
	
	private static int diceSum(int m, int n, int total) {
		if(total == 1 && n <= total)
			return 1;
		if(n<=0 || total <= 0)
			return 0;
		int sum = 0;
		for(int i=1;i<=m;i++){
			sum += diceSum(m,n-1,total-i);
		}
		return sum;
	}
}
