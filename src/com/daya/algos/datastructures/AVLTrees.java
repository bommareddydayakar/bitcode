package com.equinix.algos.datastructures;

public class AVLTrees {
	public static void main(String[] args) {
		int[] arr = {15,10,80,12,45,53, 54, 55};
		AVLNode root = new AVLNode(arr[0],0, null,null,null);
		for (int i = 1; i < arr.length; i++) {
			insert(arr[i],root);
		}
		System.out.println(root);
	}
	private static void insert(int val, AVLNode root){
		if(root.key > val){
			//left branch
			--root.balFactor;
			if(root.left != null){
				insert(val,root.left);
			}
			else{
				AVLNode left = new AVLNode(val,0,null,null,root);
				root.left = left;
				rebalance(root, left);
			}
		}else
		{
			//right branch
			++root.balFactor;
			if(root.right != null){
				insert(val,root.right);
			}
			else{
				AVLNode right = new AVLNode(val,0,null,null,root);
				root.right = right;
				rebalance(root, right);
			}
		}
	}
	private static void rebalance(AVLNode root, AVLNode child){
		if(root != null){
			if(root.balFactor < -1){
				if(root.left != null && root.left.balFactor > 0){
					//left right case
					
				}else if(root.left != null && root.left.balFactor < 0){
					//left left case
				}
				//left skewed
				AVLNode maxNode = getMaxNode(root.left);
				if(maxNode.parent.left == maxNode)
					maxNode.parent.left = null;
				else
					maxNode.parent.right = null;
				
				maxNode.parent = root.parent;
				maxNode.right = root;
				maxNode.left = root.left;
				root.left.parent = maxNode;
				root.left = null;
				
				
			}else if(root.balFactor > 1){
				//right skewed
				
				
				
			}
			rebalance(root.parent, root);
		}
		return;
	}
	private static AVLNode getMaxNode(AVLNode root){
		if(root != null){
			if(root.right == null)
				return root;
			else
				return getMaxNode(root.right);
		}
		return null;
	}
	
}

class AVLNode{
	
	int key;
	int balFactor;
	AVLNode left;
	AVLNode right;
	AVLNode parent;
	int height = 1;
		
	public AVLNode(int k, int bal, AVLNode l, AVLNode r, AVLNode p){
		key = k;
		balFactor = bal;
		left = l;
		right = r;
		parent = p;
	}
	public AVLNode(int k){
		key = k;
	}
	
}