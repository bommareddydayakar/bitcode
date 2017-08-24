package com.daya.algos;

import java.util.Scanner;

public class TwoSumSorted{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int numIms = 7;//in.nextInt();
		int target = 9;//in.nextInt();
		int[] items = {2,3,4,5,6,7,8};//new int[numIms];
		
		int i = 0, j = items.length-1;
		
		while(i<j){
			if((items[i]+items[j]) > target){
				j--;
			}else if((items[i]+items[j]) < target){
				i++;
			}else{
				System.out.println((i+1)+":"+(j+1));
				i++;
			}
		}
				
	}
	
}