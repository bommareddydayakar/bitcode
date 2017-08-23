package com.equinix.algos.datastructures;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(4);
		treeInsert(root, 2);
		treeInsert(root, 1);
		treeInsert(root, 3);
		treeInsert(root, 10);
		treeInsert(root, 15);
		treeInsert(root, 9);
		treeInsert(root, 8);
		treeInsert(root, 7);
		treeInsert(root, 6);
		treeInsert(root, 10);
		
		
		/*
		traverseTree(root);
		Node<Integer> dLL = treeToList(root);
		while(dLL != null){
			System.out.println(dLL.key);
			dLL = dLL.next;
		}
		 */		
		DoubleLinkedList<Integer> dll1 = new DoubleLinkedList<Integer>();
		dll1.addAtBegin(25);
		dll1.addAtBegin(20);
		dll1.addAtBegin(15);
		dll1.addAtBegin(10);
		dll1.addAtBegin(5);
		dll1.displayList();
		
		System.out.println("");
		System.out.println("REVERSE DOUBLY LINKED LIST ITERATIVE MANNER");
		dll1.reverseDoubleLinkedListIterative();
		dll1.displayList();
		
		System.out.println("");
		System.out.println("REVERSE DOUBLY LINKED LIST RECURSIVE MANNER");
		
		Node<Integer> cNode = dll1.head;
		Node<Integer> pNode = null;
		Node<Integer> nNode = null;
		dll1.head = dll1.reverseDoubleLinkedListRecursive(cNode, pNode, nNode);
		dll1.displayList();
		
		
		DoubleLinkedList<Integer> dll2 = new DoubleLinkedList<Integer>();
		dll2.addAtBegin(24);
		dll2.addAtBegin(19);
		dll2.addAtBegin(14);
		dll2.addAtBegin(9);
		dll2.addAtBegin(4);

		System.out.println("");
		System.out.println("DLL2 Display");
		dll2.displayList();
		System.out.println("");
		
		System.out.println("Merge 2 sorted doubly linked lists");
		DoubleLinkedList<Integer> dll3 = dll1.mergeSortedDobleLinkedLists(dll1,dll2);
		dll3.displayList();
		
		
		
		
		
	}

	

	private static Node<Integer> treeToList(Node<Integer> root) {
		Node<Integer> leftList = null;
		Node<Integer> rightList = null;
		
		if(root.prev !=null)
		{
			leftList = treeToList(root.prev);
		}
		
		if(root.next!=null)
		{
			rightList = treeToList(root.next);
		}
		
		
		if(rightList != null){
			root.next = rightList;
		}
		if(leftList != null){
			Node<Integer> leftTraverse = leftList;
			while(leftTraverse.next != null)
			{
				leftTraverse = leftTraverse.next;  
			}
			leftTraverse.next = root;
			return leftList;
		}
		return root;
	}

	private static void treeInsert(Node<Integer> root, int i) {
		Node<Integer> newNode = new Node<Integer>(i);
		if (root != null) {
			while (root != null) {
				if (root.key > i) {
					if (root.prev != null)
						root = root.prev;
					else {
						root.prev = newNode;
						root = null;
					}
				} else {
					if (root.next != null)
						root = root.next;
					else {
						root.next = newNode;

						root = null;
					}
				}
			}

		}
	}

}
class DoubleLinkedList<T>{
	Node<T> head;
	public DoubleLinkedList(){
		head = null;
	}
	
	public DoubleLinkedList<T> mergeSortedDobleLinkedLists(DoubleLinkedList<T> dll1, DoubleLinkedList<T> dll2) {
		if(dll1 == null && dll2 == null)
			return null;
		else if(dll1 == null)
			return dll2;
		else if(dll2 == null)
			return dll1;
		Node<T> c1 = dll1.head;
		Node<T> c2 = dll2.head;
		Node<T> p1 = null;
		
		while(c1 != null && c2 != null){
			int c1key = (int) c1.key;
			int c2key = (int) c2.key;
			if(c1key >  c2key){
				Node<T> tmp = c2;
				c2 = c2.next;
				tmp.next = c1;
				tmp.prev = p1;
				
				if(p1 != null)
					p1.next = tmp;
				
				if(c1 != null)
					c1.prev = tmp;
				
				if(dll1.head == c1)
					dll1.head = tmp;
			}else{
				p1 = c1;
				c1 = c1.next;
			}
		}
		if(c1 == null && c2 != null && p1 != null){
			p1.next = c2;
			c2.prev = p1;
		}
		
		return dll1;
	}

	public Node<T> reverseDoubleLinkedListRecursive(Node<T> cNode, Node<T> pNode, Node<T> nNode) {
		if(cNode == null)
			return pNode;
		nNode = cNode.next;
		cNode.next = pNode;
		pNode = cNode;
		if(cNode !=null)
			cNode.prev = nNode;
		cNode = nNode;
		return reverseDoubleLinkedListRecursive(cNode, pNode, nNode);
			
	}
	
	public void reverseDoubleLinkedListIterative() {
		Node<T> currNode = head;
		Node<T> prevNode = null;
		Node<T> nextNode = null;
		while(currNode != null){
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			if(currNode != null){
				currNode.prev = nextNode; 
			}
			currNode = nextNode;
		}
		if(prevNode != null)
			head = prevNode;
		
	}

	public void displayList() {
		Node<T> n = head;
		while (n != null) {
			System.out.print(n.key + "-->");
			n = n.next;
		}
	}
	
	public void addAtBegin(T data) {
		Node<T> n = new Node<T>(data);
		n.next = head;
		//For the first time, head will be null
		if(head != null)
			head.prev = n;
		head = n;
	}
}
class Node<T> {
	T key;
	Node<T> prev;
	Node<T> next;
	public Node(T t) {
		key = t;
	}
	@Override
	public String toString() {
		return key+"";
	}
}
