package com.equinix.algos.backtrack;

import java.util.HashSet;
import java.util.Set;
		
public class StringPermitations {
	public static void main(String[] args) {
		String s = "ABCA";
		Set<Character> set = new HashSet<Character>();
		for(int i =0; i<s.length();i++)
			set.add(s.charAt(i));
		String newS = "";
		for (Character c : set) {
			newS += c;
		}
		permuteString(newS,0,newS.length());
	}

	
	private static String permuteString(String s, int i, int n) {
		if(i == (n-1))
		{	
			System.out.println(s);
			return null;
		}
		
		for (int j = i; j < n; j++) {
			s = swap(s,i,j);
			permuteString(s,i+1,n);
			s = swap(s,i,j);
		}
		return null;
	}


	private static String swap(String s, int i, int j) {
		char[] c = s.toCharArray();
		
		char tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
		s = new String(c);
		return s;		
	}
	
	
}
