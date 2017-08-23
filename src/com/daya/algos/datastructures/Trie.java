package com.equinix.algos.datastructures;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	public static void main(String[] args) {
		String[] strs = {"the", "a", "there", "answer", "any", "by", "bye", "their", "anybody"};
		TrieNode root = new TrieNode();
		for (int i = 0; i < strs.length; i++) {
			insert(root,strs[i].toCharArray());
		}
		String[] results = {"FOUND","NOT FOUND"};
		System.out.println(results[search("the",root)]);
		System.out.println(results[search("thus",root)]);
		System.out.println(results[search("any",root)]);
		System.out.println(results[search("by",root)]);
		delete("any", root);
		System.out.println(results[search("any",root)]);
		delete("anybody", root);
		System.out.println(results[search("anybody",root)]);
	}
	private static void insert(TrieNode root, char[] chars) {
		if(chars == null || chars.length ==0){
			return;
		}
		TrieNode parent = root;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if(parent.children.containsKey(c)){
				parent = parent.children.get(c);
			}else{
				TrieNode cNode = new TrieNode();
				parent.children.put(c, cNode);
				parent = cNode;
			}
			if((i+1) == chars.length){
				parent.isLeaf = true;
				parent = null;
			}
		}
		
	}
	private static int search(String str, TrieNode root) {
		if(root == null || str == null)
			return 1;
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			root = root.children.get(chars[i]);
			if(root == null && (i+1) != chars.length )
				return 1;
			else if((i+1) == chars.length && root.isLeaf)
				return 0;
		}
		return 1;
	}
	private static int delete(String str, TrieNode root) {
		
		if(str.length() == 0){
			if(root.children == null || root.children.size() == 0){
				return 0;
			}else{
				root.isLeaf = false;
				return 1;
			}
		}else{
			int res = delete(str.substring(1),root.children.get(str.charAt(0)));
			if(res == 0 && root.children != null){
				root.children.remove(str.charAt(0));
				if(root.children.size() == 0)
					return 0;
			}
		}
		return 1;
	}

}
class TrieNode{
	Map<Character, TrieNode> children = new HashMap<Character,TrieNode>();
	boolean isLeaf = false;
	public String toString() {
		String s = "";
		if(this.children != null && this.children.size() > 0){
			for (Character key : this.children.keySet()) {
				s+=":"+key;
			}
		}
		return isLeaf+":"+s;
	}
}
