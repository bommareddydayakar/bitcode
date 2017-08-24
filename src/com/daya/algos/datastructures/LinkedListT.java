package com.daya.algos.datastructures;

public class LinkedListT {
	LLNode head;

	public LinkedListT() {
		head = null;
	}

	public void addAtBegin(int data) {
		LLNode n = new LLNode(data);
		n.next = head;
		head = n;
	}

	public void displayList() {
		LLNode n = head;
		while (n != null) {
			System.out.print(n.data + "-->");
			n = n.next;
		}
	}

	public void reverseLinkedListIter2Pointer() {
		LLNode currLLNode = this.head;
		LLNode nextLLNode = null;
		while (currLLNode != null) {
			nextLLNode = currLLNode.next;
			if (nextLLNode != null) {
				currLLNode.next = nextLLNode.next;
				nextLLNode.next = this.head;
				this.head = nextLLNode;
			} else {
				break;
			}

		}
	}

	public void reverseLinkedListIterative() {
		LLNode currLLNode = this.head;
		LLNode prevLLNode = null;
		LLNode nextLLNode = null;

		while (currLLNode != null) {
			nextLLNode = currLLNode.next;
			currLLNode.next = prevLLNode;
			prevLLNode = currLLNode;
			currLLNode = nextLLNode;
		}
		this.head = prevLLNode;
	}

	public LLNode reverseLinkedListRecursive(LLNode currNode, LLNode prevNode, LLNode nextNode) {
		if (currNode == null)
			return prevNode;
		nextNode = currNode.next;
		currNode.next = prevNode;
		prevNode = currNode;
		currNode = nextNode;
		return reverseLinkedListRecursive(currNode, prevNode, nextNode);

	}

	public LLNode reverseLinkedListRecursive(LinkedListT list, LLNode currNode) {
		if (currNode == null)
			return currNode;
		if (currNode.next != null) {
			LLNode nextNode = currNode.next;
			currNode.next = null;
			nextNode = reverseLinkedListRecursive(list, nextNode);
			nextNode.next = currNode;
			// currNode = nextNode;
		} else {
			list.head = currNode;
		}
		return currNode;
	}

	public LinkedListT mergeSortedLinkedLists(LinkedListT ll1, LinkedListT ll2) {

		if (ll1 == null && ll2 == null)
			return null;
		else if (ll1 == null)
			return ll2;
		else if (ll2 == null)
			return ll1;
		LLNode head1 = ll1.head;
		LLNode head2 = ll2.head;

		LLNode current1 = head1;
		LLNode current2 = head2;
		LLNode previous1 = head1;

		while (current1 != null && current2 != null) {
			if (current1.data > current2.data) {
				LLNode tmp = current2;
				current2 = current2.next;
				tmp.next = current1;
				if (head1 == current1)
					head1 = tmp;
				if (current1 != previous1) {
					previous1.next = tmp;
					previous1 = previous1.next;
				} else {
					previous1 = tmp;
				}
			} else {
				previous1 = current1;
				current1 = current1.next;
			}
		}
		if (current1 == null && current2 != null) {
			previous1.next = current2;
		}
		ll1.head = head1;
		return ll1;
	}

	public int length(LinkedListT ll) {
		if (ll == null || ll.head == null)
			return 0;
		int count = 0;
		LLNode current = ll.head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public LinkedListT mergeSortLL(LinkedListT ll) {
		if (ll == null || ll.head == null)
			return ll;
		int length = length(ll);
		if (length == 1)
			return ll;
		int cutOff = length / 2;
		System.out.println(length + ":" + cutOff);
		int count = 0;
		LLNode current = ll.head;
		LLNode previous = null;

		LinkedListT newLL = new LinkedListT();
		while (count < cutOff) {
			count++;
			previous = current;
			current = current.next;
		}
		newLL.head = current;
		previous.next = null;

		mergeSortLL(ll);
		mergeSortLL(newLL);
		// Merge Sorted Linked Lists
		ll = mergeSortedLinkedLists(ll, newLL);

		return ll;
	}

	public LLNode reverseLinkedListRecursiveInGroup2(LLNode head, int group) {
		if (head == null || group < 1)
			return null;
		LLNode cu = head;
		LLNode pr = null;
		LLNode nx = null;
		int count = 0;
		while(count<group && cu != null){
			nx = cu.next;
			cu.next = pr;
			pr = cu;
			cu = nx;
			count++;
		}
		
		cu = reverseLinkedListRecursiveInGroup2(cu, group);
		if(cu != null )
			head.next = cu;
			
		return pr;
	}public LLNode reverseLinkedListRecursiveInGroup(LLNode head, int group) {
		if (head == null || group < 1)
			return null;
		int count = 0;
		LLNode node = head;
		LLNode prev = null;
		LLNode next = null;
		while (count < group) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			if (node == null)
				break;
			count++;
		}
		node = reverseLinkedListRecursiveInGroup(node, group);
		if(node != null){
			next = prev.next;
			while(next != null){
				if(next.next == null)
					break;
				next = next.next;
			}
			if(next != null)
				next.next = node;
			else{
				node.next = prev;
				prev = node;
			}
		}
		return prev;

	}
}
