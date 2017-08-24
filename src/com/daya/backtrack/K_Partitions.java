package com.daya.backtrack;

import java.util.ArrayList;
import java.util.List;

public class K_Partitions {
	static List<List<Integer>> partitions = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {
		int arr[] = {7,3,5,3,2,2,5,3,6,4,6,4,2,1,7};

		//int arr[] = {7,3,5,3,2};
		int total = 0;
		int noOfPartitions = 20;
		for (int i : arr) {
			total += i;
		}
		if(total % noOfPartitions == 0){
			int pTotal = total/noOfPartitions; //10;
			System.out.println(total+":"+pTotal);
			int status[] = new int[arr.length];
			List<Integer> pList = new ArrayList<Integer>();
			System.out.println(partitionSubsets(arr,status, pList , noOfPartitions, pTotal, total));
			displayList(partitions, noOfPartitions);
		}else{
			System.out.println("partitions not possible");
		}
		
	}
	private static void displayList(List<List<Integer>> p, int k) {
		
		if(p == null || p.size() == 0 || p.size() < k){
			System.out.println("k partition is not possible");
			return;
		}
		for (List<Integer> list : p) {
			if(list != null)
			for (Integer itm : list) {
				System.out.print(itm+" ");
			}
			System.out.println(" ");
		}
	}
	
	//{7,3,5,3,2,2,5,3,6,4,6,4,2,1,7}; 10
	
	private static boolean partitionSubsets(int[] arr, int[] status, List<Integer> partitionItm, int partitionCount,int pTotal, int total) {
		if(arr == null || arr.length == 0 || (isStatusFilled(status)))
			return true;
		
		for (int i = 0; i < arr.length; i++) {
			
			//if(isSafe(partitionItm, i, (total/partitionCount))){
			if(status[i] != 1 && pTotal >= arr[i]){
				status[i] = 1;
				partitionItm.add(arr[i]);
				pTotal -= arr[i];
				if(pTotal <= 0){
					pTotal = total/partitionCount;
					partitions.add(partitionItm);
					partitionItm = new ArrayList<Integer>();
				}
				if(partitionSubsets(arr, status, partitionItm, partitionCount, pTotal, total)){
					return true;
				}
				status[i] = 0;
				pTotal += arr[i];
				if(partitionItm.size() <= 0 && partitions.size() > 0)
					partitionItm = partitions.get(partitions.size()-1);
					
				if(partitionItm != null && partitionItm.size() > 0){
					partitionItm.remove(partitionItm.size()-1);
				}
				
			}else if(i == arr.length -1){
				return false;
			}else if(arr[i] > (total/partitionCount))
				return false;
		}
		
		
		return false;
	}

	private static boolean isPartitionsDone() {
			
		return false;
	}
	private static boolean isStatusFilled(int[] status) {
		for (int i : status) {
			if(i==0)
				return false;
		}
		return true;
	}

	
}
