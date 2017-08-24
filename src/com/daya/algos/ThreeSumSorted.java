package com.daya.algos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ThreeSumSorted{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int numIms = 7;//in.nextInt();
		int target = 18;//in.nextInt();
		int[] items = {2,3,4,5,6,7,9};//new int[numIms];
		System.out.println(threeSum(items,target));
		/*for(int i=0;i<numIms;i++){
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
		}*/
		
	}
	
	public static boolean threeSum(int[] num, int target) {
		if(num == null || num.length == 0)
			return false;
		
		Arrays.sort(num);
		int l,r;
		for (int i = 0; i < num.length-2; i++) {
			l = i+1;
			r = num.length-1;
			while(l<r){
				if(num[i]+num[l]+num[r] == target){
					System.out.println(num[i]+"+"+num[l]+"+"+num[r]+"="+target);
					r--;
				//	return true;
				}else if(num[i]+num[l]+num[r] > target)
					r--;
				else
					l++;
					
			}
		}
		return false;
	}
	public static List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
	
}