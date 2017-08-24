package com.daya.algos.maths;

import java.util.List;
import java.util.ArrayList;

public class Multiply {
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		/*int n = 0;
		int carry = 0;
		arr.add(5);
		arr.add(6);
		arr.add(7);
		arr.add(8);*/
		arr.add(1);
		long start = System.nanoTime();
		for (int i = 2; i <= 5; i++) {
			multiply(arr,i,0);
		}
		System.out.println(System.nanoTime()-start);
		//multiply(arr,n,carry);
		System.out.println(arr);
		System.out.println(arr.get(arr.size()-1));
		
	}
	private static void multiply(List<Integer> list, int factor, int carry){
		int size = list.size();
		int tmp =0;
		for (int i =0; i < size; i++) {
			tmp = (list.get(i)*factor) +carry;
			carry = tmp/10;
			tmp = tmp%10;
			list.set(i,tmp);
		}
		if(carry > 9){
			tmp = carry/10;
			carry = carry%10;
			list.add(carry);
			list.add(tmp);
		}else if(carry>0)
			list.add(carry);
		
	}
}
