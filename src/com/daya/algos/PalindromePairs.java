package com.equinix.algos;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {
	public static void main(String[] args) {
		String[] strs = {"tab","bat","cat"};
		List<String> list = paliPairs(strs);
		if(list != null){
			for (String string : list) {
				System.out.println(string);
				
			}
		}
	}

	public static List<String> paliPairs(String[] strs) {
		if(strs == null || strs.length ==0 ||strs.length ==1)
			return null;
		int sLen = strs.length;
		List<String> list = new ArrayList<String>();
		//int[][] track = new int[sLen*sLen-1][2];
		int ind =0;
		for(int i=0;i<sLen;i++){
			for(int j=0;j<sLen;j++){
				if(i==j)
					continue;
				if(isPalindromes(strs[i],strs[j])){
					list.add("["+i+","+j+"]");
				}
			}
		}
		return list;
		
		
	}

	private static boolean isPalindromes(String s, String t) {
		
		if(s == null || t == null || s.length() != t.length())
			return false;
		int sLen = s.length();
		for(int i=0;i<sLen;i++){
			if(s.charAt(i) != t.charAt(sLen-1-i)){
				return false;
			}
		}
		
		return true;
	}
}
