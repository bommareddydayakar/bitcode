package com.equinix.algos.datastructures;

public class AVLTrees2 {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 31);
		tree.root = tree.insert(tree.root, 38);
		tree.root = tree.insert(tree.root, 40);
		AVLTree.preOrder(tree.root);
		System.out.println("produce left left case and preorder print");
		tree.root = tree.insert(tree.root, 9);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 11);
		tree.root = tree.insert(tree.root, 36);
		tree.root = tree.insert(tree.root, 35);
		tree.root = tree.insert(tree.root, 34);
		tree.root = tree.insert(tree.root, 33);
		tree.root = tree.insert(tree.root, 32);
		tree.root = tree.insert(tree.root, 100);
		tree.root = tree.insert(tree.root, 99);
			AVLTree.preOrder(tree.root);
		
		
	}
}

class AVLTree{
	AVLNode root;
	
	public AVLNode insert(AVLNode rt, int i) {
		if(rt == null){
			rt = new AVLNode(i);
		}
		else if(rt.key > i){
			rt.left =  insert(rt.left,i);
		}
		else
			rt.right = insert(rt.right,i);
		rt.height = height(rt);
		int balance = balance(rt);
		
		// left cases
		if(balance < -1){
			if(balance(rt.left)<0){
				System.out.println("LEFT-LEFT ROTATION REQUIRED");
				return rotateLeftLeft(rt);
			}else if(balance(rt.left) > 0){
				System.out.println("LEFT-RIGHT ROTATION REQUIRED");
				return rotateLeftRight(rt);
			}			
		}
		// right cases
		if(balance > 1){
			if(balance(rt.right) > 0){
				System.out.println("RIGHT-RIGHT ROTATION REQUIRED");
				return rotateRightRight(rt);
			}else if(balance(rt.right) < 0){
				System.out.println("RIGHT-LEFT ROTATION REQUIRED");
				return rotateRightLeft(rt);
				
			}			
		}
		return rt;
	}
	private AVLNode rotateRightLeft(AVLNode rt) {
		if(rt != null){
			rt.right = rotateLeftLeft(rt.right);
			return rotateRightRight(rt);
		}
		return null;
	}
	private AVLNode rotateLeftRight(AVLNode rt) {
		if(rt != null){
			rt.left = rotateRightRight(rt.left);
			return rotateLeftLeft(rt);
		}
		return null;
	}
	private AVLNode rotateLeftLeft(AVLNode rt) {
		if(rt != null){
			AVLNode rTmp = rt.left;
			rt.left = rTmp.right;
			rTmp.right = rt;
			return rTmp;	
		}
		return null;
	}
	private AVLNode rotateRightRight(AVLNode rt) {
		if(rt != null){
			AVLNode rTmp = rt.right;
			rt.right = rTmp.left;
			rTmp.left = rt;
			return rTmp;	
		}
		return null;
	}
	private int balance(AVLNode rt) {
		if(rt == null)
			return 0;
		int lH = 0;
		if(rt.left != null)
			lH = 1+height(rt.left);
		int rH = 0;
		if(rt.right != null)
			rH = 1+height(rt.right);
		return rH-lH;
	}
	private static int height(AVLNode root){
		if(root == null || (root.left == null && root.right == null)){
			return 0;
		}
		return 1+Math.max(height(root.left), height(root.right));
	}
	public static void preOrder(AVLNode root){
		if(root != null){
			System.out.println(root.key);
			preOrder(root.left);
			preOrder(root.right);
		}
		return;
	}
	
}
