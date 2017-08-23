package com.equinix.algos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ThreeSumUnSorted{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int numIms = 7;//in.nextInt();
		int target = 18;//in.nextInt();
		int[] items = {2,3,4,5,6,7,9};//new int[numIms];
		
		for(int i=0;i<numIms;i++){
			int j=i+1,k=numIms-1;
			if(j<numIms){
				while(j<k){
					if((items[i]+items[j]+items[k]) == target){
						System.out.println(items[i]+":"+items[j]+":"+items[k]);
						k--;
					}else if((items[i]+items[j]+items[k]) < target){
						j++;
					}else if((items[i]+items[j]+items[k]) > target){
						k--;
					}
				}
				
			}
		}
		
	}
}