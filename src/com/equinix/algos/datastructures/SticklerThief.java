package com.equinix.algos.datastructures;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SticklerThief {
	
	public static void main(String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int nuTC = sc.nextInt();
		int tcItms[] = new int[nuTC];
		int tcs[][] = new int[nuTC][];
		
		for(int i=0;i<nuTC;i++){
		    tcItms[i] = sc.nextInt();
		    tcs[i] = new int[tcItms[i]];
    		for(int j=0;j<tcItms[i];j++){
    		    tcs[i][j] = sc.nextInt();
    		}    
		}
		sc.close();
		System.out.println("  ***************************    ");
		for(int i=0;i<nuTC;i++){
		    System.out.println(max(tcs[i]));
		}
	}
	
	private static int max(int[] wealth){
	    int max1 = 0;
	    int max2 = 0;
	    
	    for(int i=0;i<wealth.length;i+=2){
	        max1 += wealth[i];
		}
	    
	    for(int i=1;i<wealth.length;i+=2){
	        max2 += wealth[i];
		}
	    return Math.max(max1,max2);
	}
}