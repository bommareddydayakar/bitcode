package com.daya.algos.Strings;

public class LongestCommonSubstring
{
 
  /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
  int lcs( char[] X, char[] Y, int m, int n )
  {
	 int[][] tmp = new int[m+1][n+1];
	 int max = 0;
	 int maxIndI = 0,maxIndJ=0;
	 for(int i=0;i<m;i++){
		 for(int j=0;j<n;j++){
			 if(X[i] == Y[j] ){
				 tmp[i+1][j+1] = tmp[i][j]+1;
				 if(tmp[i+1][j+1]>max){
					 max = tmp[i+1][j+1];
					 maxIndI = i+1;
					 maxIndJ = j+1;
				 }
				 
			 }else{
				 tmp[i+1][j+1] = 0;
			 }
		 }
	 }
	/* String s = "";
	 for(;maxIndI>0&&maxIndJ>0;){
		 while(tmp[maxIndI][maxIndJ] > 0){
			 s+=X[maxIndI-1];
			 maxIndI--;maxIndJ--;
		 }
		 break;
	 }
	 System.out.println(s);
	*/ return max;
	 
	 
  }
 
  /* Utility function to get max of 2 integers */
  int max(int a, int b)
  {
    return (a > b)? a : b;
  }
 
  public static void main(String[] args)
  {
    LongestCommonSubstring lcs = new LongestCommonSubstring();
    String s1 = "xabcjdefuuuua";
    String s2 = "zabcjuuuua";
 
    char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    int m = X.length;
    int n = Y.length;
 
    System.out.println("Length of LCS is" + " " +
                                  lcs.lcs( X, Y, m, n ) );
  }
 
}