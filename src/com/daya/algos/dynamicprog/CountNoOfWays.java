package com.daya.algos.dynamicprog;

public class CountNoOfWays {
	public static void main(String[] args) {
		int n = 5;
		System.out.println("Number of ways to cover dist "+n+" is:"+countWaysDP(n));
	}

	private static int countWaysRec(int n) {
		if(n < 0 )
			return 0;
		else if(n ==0)
			return 1;
		else{
			return countWaysRec(n-1)+countWaysRec(n-2)+countWaysRec(n-3); 
		}
	}
	
	private static int countWaysDP(int n) {
		int[] dis = new int[n+1];
		dis[0] = 1;
		dis[1] = 1;
		dis[2] = 2;
		
		for(int i=3;i<=n;i++){
			dis[i] = dis[i-1]+dis[i-2]+dis[i-3];
		}
		
		return dis[n];
	}
}
