package com.daya.algos.dynamicprog;

public class BinomialCoeff {
	
	public static void main(String[] args) {
		int n=3;
		int k=2;
		
		System.out.println("The Binomical Coeff is:"+binomialCoeffRec(n,k));
		System.out.println("The Binomical Coeff is:"+binomialCoeffFormulae(n,k));
		System.out.println("The Binomical Coeff is:"+binomialCoeffTabulation(n,k));
		
	}

	private static int binomialCoeffFormulae(int n, int k) {
		
		return factorial(n)/(factorial(k)*factorial(n-k));
	}
	
	private static int factorial(int k) {
		if(k ==0 || k == 1)
			return 1;
		
		return k*factorial(k-1);
	}

	private static int binomialCoeffRec(int n, int k) {
		if(k==0 || n==k)
			return 1;
		return binomialCoeffRec(n-1, k-1)+binomialCoeffRec(n-1,k);
	}
	
	private static int binomialCoeffTabulation(int n, int k) {
		
		int res[][] = new int[n+1][k+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				if(j==0 || j==i)
					res[i][j] = 1;
				else{
					res[i][j] = res[i-1][j-1]+res[i-1][j];
				}
			}
		}
		
		return res[n][k];
	}
	
	
	
	
}
