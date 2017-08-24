package com.daya.algos.datastructures;

public class LLNode {
	int data;
	LLNode next;
	boolean visited;
	public LLNode(int d) {
		data = d;
		next = null;
		visited = false;
	}
}