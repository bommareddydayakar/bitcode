package com.equinix.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TwoSumUnsorted{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int numIms = 4;//in.nextInt();
		int target = 9;//in.nextInt();
		int[] items = {5,4,6,3};//new int[numIms];
		
		for(int i=0;i<numIms;i++){
			//items[i] = in.nextInt();
		}
		int[] res = twoSumSingle(items,target);
		if(res != null && res.length == 2){
			System.out.println(res[0]+":"+res[1]);
		}
		
		System.out.println(twoSumMultiple(items, target));
		System.out.println("end");
		
	}
	private static List<String> twoSumMultiple(int[] items, int target){
		if(items == null || items.length == 0)
			return null;
		List<String> list = new ArrayList<String>();
		int j =0;
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < items.length; i++) {
			if(!map.containsKey(target - items[i]))
				map.put(items[i], i);
			else{
				list.add(map.get(target - items[i])+":"+i);
			}
		} 
	
		return list;
	}
	private static int[] twoSumSingle(int[] items, int target){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		int[] results = new int[2];
		for(int i=0;i<items.length;i++){
			if(map.get(items[i]) != null){
				results[0] = map.get(items[i]);
				results[1] = i;
				break;
			}else{
				map.put(target-items[i], i);
			}
			
			
			/*for(int j=i;j<items.length;j++){
				//if(i==j) continue;
				if(items[i]+items[j] == target){
					results[0] = i;
					results[1] = j;
					i=items.length;break;
				}
			}*/
		}
		return results;
	}
}