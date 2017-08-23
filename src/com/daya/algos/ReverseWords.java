package com.equinix.algos;

public class ReverseWords {
	public static void main(String[] args) {
		String s = " 0 123 456 789";
		if(s != null && s.length() >0){
			s = s.trim();
			char[] sAr = s.toCharArray();
			System.out.println(reverseWords(sAr,s).trim());
		}else{
			System.out.println("Wrong input");
		}
		
	}

	private static String reverseWords(char[] sAr,String s) {
		StringBuffer sb = new StringBuffer();
		for (int j=(sAr.length-1), i = (sAr.length-1);  i >-1; i--) {
			if(i==0 || sAr[i-1] == ' ' ){
				if(j<0)
					break;
				sb.append(s.substring(i,j+1)).append(" ");
				j = i-2;
				
			}
		}
		return sb.toString();
	}
}
	/*
	public static void reverseWords(char[] s) {
	    int i=0;
	    for(int j=0; j<s.length; j++){
	        if(s[j]==' '){
	            reverse(s, i, j-1);        
	            i=j+1;
	        }
	    }
	 
	    reverse(s, i, s.length-1);
	 
	    reverse(s, 0, s.length-1);
	}
	 
	public static void reverse(char[] s, int i, int j){
	    while(i<j){
	        char temp = s[i];
	        s[i]=s[j];
	        s[j]=temp;
	        i++;
	        j--;
	    }
	}
}
*/