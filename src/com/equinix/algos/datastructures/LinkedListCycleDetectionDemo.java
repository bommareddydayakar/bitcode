package com.equinix.algos.datastructures;

public class LinkedListCycleDetectionDemo {
	public static void main(String args[]) {
		LinkedListT list = new LinkedListT();
		
		list.addAtBegin(6);
		list.addAtBegin(5);
		list.addAtBegin(4);
		list.addAtBegin(3);
		list.addAtBegin(2);
		list.addAtBegin(1);
		
		
		
		
		//Cycle forming
		// 5-->next-->2
		list.head.next.next.next.next.next.next = list.head;
		//Detect & remove Cycle
		if(isCycleFound(list)){
		 //	removeCycle(list);
		}
		list.displayList();
		
		
		// Calcualtions
		
		LinkedListT list2 = new LinkedListT();
		list2.addAtBegin(9);
		list2.addAtBegin(9);
		list2.addAtBegin(9);
		list2.addAtBegin(1);
		int j =add(100000,list2.head);
		if(j > 0 && j<10){
			LLNode newHead = new LLNode(j);
			newHead.next = list2.head;
			list2.head = newHead;
		}else if(j > 9){
			while(j > 0){
				LLNode newHead = new LLNode(j%10);
				newHead.next = list2.head;
				list2.head = newHead;
				j= j/10;
			}
		}
		System.out.println("");
		list2.displayList();
		
	}

	private static int add(int i, LLNode node) {
		int j =0;
		if(node.next == null){
			j = node.data + i;
		}else{
			j = add(i, node.next);
			j = j+node.data;
		}
		if(j > 9){
			node.data = j%10;
			return j/10;
		}else{
			node.data = j;
			j = 0;
		}
		return j;
	}

	private static boolean isCycleFound(LinkedListT list) {
		if(list == null)
			return false;
		LLNode tortoise = list.head;
		LLNode hare = list.head;
		while(tortoise != null && hare != null){
			tortoise = tortoise.next;
			if(hare.next != null && hare.next.next != null)
				hare = hare.next.next;
			
			//Cycle found
			if(tortoise == hare)
			{
				System.out.println("Cycle found");
				//removeCycleFloyd1(tortoise,list.head);
				removeCycleFloyd2(tortoise,list.head);
				
				return true;
			}
		}
		return false;
	}

	private static void removeCycleFloyd2(LLNode loop, LLNode head) {
		LLNode p1 = head;
		LLNode p2 = loop;
		if(p1 == p2)
		{
			System.out.println("Circular linked list found!");
			while(p2.next != head){
				p2 = p2.next;
			}
			p2.next = null;
			return;
		}
		while(true){
			p1 = p1.next;
			if(p2.next == p1){
				System.out.println(p1.data+" is the cycle start");
				p2.next = null;
				break;
			}
		}
	}
	private static void removeCycleFloyd1(LLNode loop, LLNode head) {
		LLNode p1 = head;
		LLNode p2 = loop;
		while(true){
			while(p2 != null && p2.next != loop && p2.next != p1){
				p2 = p2.next;
				
			}
			if(p2.next != p1){
				p1 = p1.next;
				p2 = loop;
			}else{
				System.out.println("Start of the cycle is:"+p1.data);
				p2.next = null;
				break;
			}
			
		}
		
	}

	private static void removeCycleLinear(LinkedListT list) {
		LLNode curr = list.head;
		LLNode prev = null;
		while(curr != null && !curr.visited){
			curr.visited = true;
			prev = curr;
			curr = curr.next;			
		}
		//Prev is the end of the loop
		if(prev != null){
			prev.next = null;
		}
		
	}

}



