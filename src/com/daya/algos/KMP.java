package com.daya.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KMP {		
					 //012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789	
	static String S = "ABCDABCDABDE ABCDABCDABDE ABCDABCDABDE ABCDABCDABDE  ABCDABCDABDE ABCDABCDABDE  ABCDABCDABDE ABCDABCDABDE ";
	static String M = "dsdd";
	public static void main(String[] args) {
		S.toCharArray();
		findMatches(S.toCharArray(),M.toCharArray());
	}
	private static void findMatches(char[] S, char[] M) {
		int j = 0;
		int subMatch = 0;
		List<String> matchList = new ArrayList<String>();
		for (int i = 0; i < S.length; ) {
			subMatch = 0;
			if(M[0] != S[i]){
				i++;
				continue;
			}
			j = i++;
			for (int k = 1; k < M.length; k++) {
				if((j+1) < S.length){
					if(M[0] == S[++j] && subMatch ==0)
						subMatch = j; 
						
					if( M[k] != S[j]){
						i = j;
						break;
					}
					if(k == (M.length -1)){
						matchList.add((i-1)+":"+j);
						i=j+1;
						continue;
					}
				}
			}
			if(subMatch != 0){
				i = subMatch;
				System.out.println("submatch"+subMatch);
			}
		}
		System.out.println(matchList.toString());
	}
}
/*
i =6 sm=0 
i = 7 j=6 k=1  
j=7
*/