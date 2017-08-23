package com.equinix.algos.dynamicprog;

public class EditStringDist {

	public static void main(String[] args) {
		String s1 = "bat";
		String s2 = "mbu";
		System.out.println(editStringDistDP(s1,s2,s1.length(),s2.length()));
	}

	private static int editStringDistRecursive(String s1, String s2, int s1Len, int s2Len) {
		if(s1Len == 0)
			return s2Len;
		if(s2Len == 0)
			return s1Len;
		if(s1.charAt(s1Len-1) == s2.charAt(s2Len-1)){
			return editStringDistRecursive(s1, s2, s1Len-1, s2Len-1);
		}else{
			return 1+ min(
					editStringDistRecursive(s1, s2, s1Len, s2Len-1),
					editStringDistRecursive(s1, s2, s1Len-1, s2Len),
					editStringDistRecursive(s1, s2, s1Len-1, s2Len-1)
				);			
		}
	}
	
	private static int editStringDistDP(String s1, String s2, int s1Len, int s2Len) {
		int dp[][] = new int[s1Len+1][s2Len+1];
		
		for(int i=0;i<s1Len+1;i++){
			for(int j=0;j<s2Len+1;j++){
				if(i==0){
					dp[i][j] = j;
				}else if(j==0){
					dp[i][j] = i;
				}else if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = 1+ min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
				}
			}
		}
		return dp[s1Len][s2Len];
	}
	
	
	
	private static int min(int i, int j, int k) {
		return Math.min(i, Math.min(j, k));
	}
}
