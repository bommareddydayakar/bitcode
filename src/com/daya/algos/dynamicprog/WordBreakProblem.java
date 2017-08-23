package com.equinix.algos.dynamicprog;

public class WordBreakProblem {
	public static void main(String[] args) {
		String[] s = {"i","like","sam","sung"};
		String t = "ilikesamsung";
		System.out.println("Is search string found?"+find(s,t));
	}

	private static boolean find(String[] s, String t) {
		if(t.length() <= 0)
			return true;
		for (int k = 0; k < t.length(); k++) {
			if(findInArray(s,t.substring(0,k+1)) && find(s,t.substring(k+1)) ){
				return true;
			}			
		}
		return false;
	}
	private static boolean findInArray(String[] s, String t){
		for (int j = 0; j < s.length; j++) {
			if(s[j].equals(t))
				return true;
		}
		return false;
	}
}
