package com.daya.algos;

public class Euclid {
	
	public static void main(String[] args) {
		/*
		 * Scanner should be used to fetch input
		 */
		
		/*int j=1860;
		int i=2015;
		int hcf = 0;
		if(i>j){
			hcf = getHCF2(i,j);
		}else{
			hcf = getHCF2(j,i);
		}	
		System.out.println(hcf);*/
		
		
		
		
		
	}

	private static int getHCF2(int i, int j) {
		int r = i%j;
		//System.out.println(r+":"+i+":"+j);
		if(r==0)
			return j;
		else
			return getHCF2(j,r);		
	//	return 1;
	}
	private static int getHCF(int i, int j) {
		for(int q=1;q<j;q++){
			int r = i - (j*q);
			if(r==0)
				return j;
			else if(r<0)
				return getHCF(j,(i-(j*(q-1))));
			else
				continue;
		}
		
		
		
		return 1;
	}
	
	
}
