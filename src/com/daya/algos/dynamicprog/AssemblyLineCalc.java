package com.daya.algos.dynamicprog;

public class AssemblyLineCalc {
	public static void main(String[] args) {
		int noOfStation = 2;
		int stations[][] = {
				{4, 5, 3, 2 },
                {2, 10, 1, 4}
			};
		int transitionCost[][] = {
				{0, 7, 4, 5},
                {0, 9, 2, 8}
				};
		int entry[] = {10, 12}, exit[] = {18, 7};
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < stations.length; i++) {
			min = Math.min(min, assemblyLineCost(stations,transitionCost,entry,exit, i, 0));
		}
		System.out.println(min);
		//System.out.println("The minimum cost of car production is:"+assemblyLineCost(stations,transitionCost,entry,exit));
		
	}
	private static int assemblyLineCost(int[][] stations, int[][] transitionCost, int[] entry, int[] exit) {
		int[][] dict = new int[stations.length][stations[0].length];
		//for (int i = 0; i < stations.length; i++) {
		int i=0;
			for (int j = 0; j < stations[i].length; j++) {
				int nextI = (i+1)%stations.length;
				if(j==0){
					dict[i][j] = entry[i]+stations[i][j];
					dict[nextI][j] = entry[nextI]+stations[nextI][j];
					
				}
				else{
					dict[i][j] = Math.min(stations[i][j]+dict[i][j-1], transitionCost[nextI][j]+stations[i][j]+dict[nextI][j-1]);
					dict[nextI][j] = Math.min(stations[nextI][j]+dict[nextI][j-1], transitionCost[i][j]+stations[nextI][j]+dict[i][j-1]);
					
				}
				if(j == stations[i].length-1){
					dict[i][j] += exit[i];
					dict[nextI][j] += exit[nextI];
					
				}
				
			}
		return dict[stations.length-1][stations[0].length-1];
	}
	private static int assemblyLineCost(int[][] stations, int[][] transitionCost, int[] entry, int[] exit,int i, int j) {
		int minCost = 0;
		if(i<0 || i>stations.length-1 || j<0 || j>stations[i].length-1)
			return 0;
		if(j == stations[i].length)
			return exit[i];
		int nextI = (i+1)%stations.length;
		
		int minCost1 =	stations[i][j]+assemblyLineCost(stations, transitionCost, entry, exit, i, j+1);
		
		int minCost2 =  stations[i][j]+transitionCost[i][j]+assemblyLineCost(stations, transitionCost, entry, exit, nextI, j+1);
		
		if(j==stations[i].length-1)
		{
			minCost1 += exit[i];
			minCost2 += exit[nextI];
		}
		if(j==0){
			minCost1 += entry[i];
			minCost2 += entry[nextI];
		}
		minCost = Math.min(minCost1, minCost2);
		
		return minCost;
	}
}
