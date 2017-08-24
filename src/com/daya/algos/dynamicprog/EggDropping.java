package com.daya.algos.dynamicprog;

public class EggDropping {
	public static void main(String[] args) {
		int floors = 10;
		int eggs = 2;
		int trails[][] = new int[eggs+1][floors+1];
		for (int i = 0; i < trails.length; i++) {
			for (int j = 0; j < trails[i].length; j++) {
				trails[i][j] = -1;
			}
			
		}
		System.out.println("The minimum trials to find solution is:"+eggDrop(floors,eggs,trails));
		
	}

	private static int eggDrop(int k, int n,int[][] trials) {
		if(trials[n][k] != -1)
			return trials[n][k];
		
		if(k == 0 || k == 1)
			trials[n][k] = k;
		
		else if(n == 1)
			trials[n][k] = k;
		else{
			int res = 0,min = Integer.MAX_VALUE;
			for(int x=1;x<=k;x++){
				res = Math.max(eggDrop(x-1,n-1,trials),eggDrop(k-x,n,trials));
				if(res < min)
					min = res;
			}	
			trials[n][k] = min+1;
		}
		
		return trials[n][k];
	}
	private static int eggDrop(int k, int n) {
		if(k == 0 || k == 1)
			return k;
		
		if(n == 1)
			return k;
		
		int res = 0,min = Integer.MAX_VALUE;
		for(int x=1;x<=k;x++){
			res = Math.max(eggDrop(x-1,n-1),eggDrop(k-x,n));
			if(res < min)
				min = res;
		}
		return min+1;
	}
}
