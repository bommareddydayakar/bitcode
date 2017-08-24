package com.daya.algos;

public class OneEditDistance {
	public static void main(String[] args) {
		String s = " m";
		String t = "  m";
		System.out.println(isOneEdit(s, t));
	}

	public static boolean isOneEdit(String s, String t) {
		if(s == null || t == null || s.length() == 0 || t.length() == 0 || Math.abs(s.length()-t.length())>1){
			return false;
		}else{
			int count = 0,i=0,j=0;
			int sLength = s.length(), tLength = t.length();
			
			while(i<sLength && j<tLength){
				if(s.charAt(i) == t.charAt(j)){
					i++;j++;
				}else{
					count++;
					if(count>1){
						return false;
					}
					if(sLength>tLength){
						i++;
					}if(sLength<tLength){
						j++;
					}else{
						i++;j++;
					}
				}
			}
		}
		return true;
	}
}
