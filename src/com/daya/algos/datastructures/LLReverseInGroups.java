package com.equinix.algos.datastructures;

public class LLReverseInGroups {
	public static void main(String args[]) {
		LinkedListT list = new LinkedListT();
		list.addAtBegin(1); 
		list.addAtBegin(2);
		list.addAtBegin(3);
		list.addAtBegin(4); 
		list.addAtBegin(5);
		list.addAtBegin(6);
		/*
		list.addAtBegin(7); 
		list.addAtBegin(8);
		list.addAtBegin(9);
	*/	//list.addAtBegin(10); 
		//list.addAtBegin(11);
		//list.addAtBegin(12);
		int group = 1;
		System.out.println("Original Linked List");
		list.displayList();
		list.head = list.reverseLinkedListRecursiveInGroup2(list.head, group);
		System.out.println("reversed Linked List");
		list.displayList();
		
	}

}



