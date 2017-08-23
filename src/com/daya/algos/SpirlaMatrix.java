package com.equinix.algos;

public class SpirlaMatrix {
	public static void main(String[] a){
		spiral(new int[4][4]);
	}
	public static void spiral(int[][] n){

		int i = 0;
		int j = 0,ind=0;
		int rows = 3, cols = 3,rI =0, cI=0;
		boolean rB = false, cB = true,inc = false;;
		while(true){
			//System.out.println(i+":"+j);
			ind++;
			
			if(ind>rows*cols) break;
			//System.out.println(cB+":"+rB+":"+i+"--->"+j);
			System.out.println(i+":"+j);
			
			if(cB && (j+1) == cols ){
				cB = false;
				rB = true;
			}
			if(rB && (i+1) == rows && j>0){
				cB = true;
				rB = false;
			}
			if(cB && rB){
				cB = true;
				rB = false;
			}
			
			if(!rB && cB && (j+1)<cols && (i+1)<rows){
				j++;
				rI++;
			}else if(!cB && rB && (i+1)<rows && (j+1)==cols){
				i++;
				cI++;
			}else if(!rB && cB && j > cI){
				j--;
				if(j>cI){
					cB = false;
					rB = true;
				}
			}else if(rB && !cB && i>rI){
				i--;
			}	
			
		}	
}
}
