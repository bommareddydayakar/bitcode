package com.daya.algos.dynamicprog;

import java.util.Arrays;

public class ChainOfPairs {
	public static void main(String[] args) {
		int arr[][] = { 
					{5, 24}, 
					{15, 25},
					{27, 40}, 
					{50, 60} 
				};
		//Prepare Nodes
		Node[] nodes = new Node[4];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(arr[i][0],arr[i][1]);
		}
		
		System.out.println("Chain of pairs are: "+chainOfPairs(nodes));
	}

	private static int chainOfPairs(Node[] nodes) {
		//Sort nodes array based on its begining element
		Arrays.sort(nodes);
		int[] dict = new int[nodes.length];
		
		for (int i = 0; i < dict.length; i++) {
			dict[i] = 1;
		}
		for (int i = 1; i < nodes.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nodes[i].be > nodes[j].en){
					dict[i] = Math.max(dict[i], dict[j]+1);
				}
			}
		}
		
		
		
		
		return dict[nodes.length-1];
	}
}

class Node implements Comparable<Node>{
	int be;
	int en;
	Node(int b, int e){
		be = b;
		en = e;
	}
	@Override
	public int compareTo(Node o) {
		return this.be-o.be;
	}
	
	
	
}
