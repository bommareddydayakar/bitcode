package com.equinix.algos.datastructures;

public class LinkedListCustom {
	public static void main(String args[]) {
		LinkedListT list = new LinkedListT();
		LinkedListT list2 = new LinkedListT();
		list.addAtBegin(10); 
		list.addAtBegin(5);
		list.addAtBegin(20);
		/*list.addAtBegin(15);
		list.addAtBegin(25);
		list.addAtBegin(30);
		*///list = list.mergeSortedLinkedLists(list2, list);
		list.displayList();
		System.out.println("");
		
		System.out.println("reverse rec LL");
		list.reverseLinkedListRecursive(list,list.head);
		list.displayList();
		
		
		/*
		System.out.println("Sort LL");
		list = list.mergeSortLL(list);
		list.displayList();
	
		System.out.println("");
		System.out.println("Sort LL");
		list = list.mergeSortLL(list);
		list.displayList();
	
		
		
		System.out.println("Reversing LL Iterative with 2 pointer");
		list.reverseLinkedListIter2Pointer();
		list.displayList();

		System.out.println("");
		System.out.println("Reversing LL Recursive");
		LLNode currNode = list.head;
		LLNode prevNode = null;
		LLNode nextNode = null;
		list.head = list.reverseLinkedListRecursive(currNode, prevNode, nextNode);
		list.displayList();

		// sorting
		LinkedListT list1 = new LinkedListT();
		list1.addAtBegin(21);
		list1.addAtBegin(20);
		list1.addAtBegin(18);
		list1.addAtBegin(6);
		list1.addAtBegin(2);

		LinkedListT list2 = new LinkedListT();
		list2.addAtBegin(19);
		list2.addAtBegin(17);
		list2.addAtBegin(3);
		list2.addAtBegin(1);

		list1.head = list1.mergeSortedLinkedLists(list1.head, list2.head);
		System.out.println("");
		System.out.println("Merging two sorted linked lists");
		list1.displayList();
*/

	}

}



