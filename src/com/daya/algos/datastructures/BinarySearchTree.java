package com.daya.algos.datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	public static void main(String[] args) {
		BSTNode root = new BSTNode(15);
		insert(root,8);
		insert(root,20);
		insert(root,7);
		insert(root,9);
		insert(root,16);
		insert(root,25);	
		
		insert(root,23);	
		insert(root,30);	
		insert(root,22);	
		insert(root,24);	
		insert(root,28);	
		insert(root,35);
		insert(root,26);	
		insert(root,27);	
		
		searchNDelNd(root,25,null);
		
		System.out.println(root);
		System.out.println(search(root, -1));
		System.out.println(height(root));
		
		System.out.println("---------------------BFS--------------------------------");
		Queue<BSTNode> qu = new LinkedList<BSTNode>();
		qu.add(root);
		BFS(qu);
		
		System.out.println("---------------------DFSPreOrder--------------------------------");
		DFSPreOrder(root);
		
		System.out.println("---------------------DFSInOrder--------------------------------");
		DFSInOrder(root);
		
		System.out.println("---------------------DFSPostOrder--------------------------------");
		DFSPostOrder(root);
		
		
		System.out.println("---------------------Binary tree is BST??--------------------------------");
		System.out.println(isBST(root));
		
		
	}
	
	
	private static BSTNode searchNDelNd(BSTNode root, int i, BSTNode parent) {
		if(root == null)
			return null;
		
		if(root.key == i){
			return deleteNode(root, parent);
		}
		else if(root.key < i){
			searchNDelNd(root.right, i,root);
		}
		else{
			searchNDelNd(root.left, i,root);
		}
		return null;	
	}


	private static BSTNode deleteNode(BSTNode root,BSTNode parent) {
		if(root != null){
			BSTNode child = null;
			if(root.left == null && root.right == null){
				if(parent != null && parent.key > root.key)
					parent.left = null;
				else if(parent != null && parent.key < root.key)
					parent.right = null;
				return root;
			}
			else if(root.left == null && root.right != null){
				// Has 1 children case
				child = root.right;
				if(parent.key < child.key)
					parent.right = child;
				else
					parent.left= child;
				return child;
			}else if(root.left != null && root.right == null){
				// Has 1 children case
				child = root.left;
				if(parent.key >= child.key)
					parent.left = child;
				else
					parent.right= child;
				return child;
			}else if(root.left != null && root.right != null){
				// Has 2 children case
				int max = findMaxInLeftTree(root.left);
				searchNDelNd(root,max,parent);
				root.key = max;
			} 
		}
		return null;
	}


	private static int findMaxInLeftTree(BSTNode root) {
		int max = Integer.MIN_VALUE;
		if(root != null){
			max = root.key;
			return Math.max(max, findMaxInLeftTree(root.right));
		}
		return max;
	}

	private static int findMinInRightTree(BSTNode root) {
		int min = Integer.MAX_VALUE;
		if(root != null){
			min = root.key;
			return Math.min(min, findMaxInLeftTree(root.right));
		}
		return min;
	}


	private static boolean isBST(BSTNode root) {
		if(root == null)
			return true;
		if(root.left != null && root.key <root.left.key)
			return false;
		if(root.right != null && root.key > root.right.key)
			return false;
		
		return isBST(root.left) && isBST(root.right);
	}


	private static void DFSPreOrder(BSTNode root) {
		if(root != null){
			System.out.println(root.key);
			DFSPreOrder(root.left);
			DFSPreOrder(root.right);
		}
			
	}
	private static void DFSInOrder(BSTNode root) {
		if(root != null){
			DFSInOrder(root.left);
			System.out.println(root.key);
			DFSInOrder(root.right);
		}
			
	}
	private static void DFSPostOrder(BSTNode root) {
		if(root != null){
			DFSPostOrder(root.left);
			DFSPostOrder(root.right);
			System.out.println(root.key);
		}
			
	}


	private static void BFS(Queue<BSTNode> queue){
		
		while(queue != null && !queue.isEmpty()){
			BSTNode node = queue.poll();
			if(node != null)
				System.out.println(node.key);
			if(node.left !=null)
				queue.add(node.left);
			if(node.right !=null)
				queue.add(node.right);
		}
		
	}
	
	private static int height(BSTNode root){
		if(root == null || (root.left == null && root.right == null)){
			return 0;
		}
		return 1+Math.max(height(root.left), height(root.right));
	}
	
	
	private static boolean search(BSTNode root, int s) {
		if(root != null){
			if(root.key == s)
				return true;
			else if(root.key > s){
				return search(root.left,s);
			}else{
				return search(root.right,s);
			}
		}
		return false;
	}
	private static void insert(BSTNode root, int k) {
		if(root.key > k){
			//insert in left branch
			if(root.left == null){
				BSTNode left = new BSTNode(k);
				root.left = left;
				return;
			}
			insert(root.left,k);
		}else{
			//insert in right branch
			if(root.right== null){
				BSTNode right= new BSTNode(k);
				root.right = right;
				return;
			}
			insert(root.right,k);
		}
	}
}

class BSTNode{
	int key;
	BSTNode left;
	BSTNode right;
	public BSTNode(int k){
		key = k;
	}
}

