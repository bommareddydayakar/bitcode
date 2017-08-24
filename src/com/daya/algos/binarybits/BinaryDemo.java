package com.daya.algos.binarybits;

public class BinaryDemo {
	public static void main(String[] args) {
		int n = 20;
		System.out.println(Integer.toBinaryString(' '));
		System.out.println(Integer.toBinaryString('_'));
		System.out.println(n+" is odd? "+isOddEven(n));
		System.out.println("add 1 to given integer  "+n+" : "+incrementOne(n));
		// Turn off K'th bit of a given number
		turnOffKBit(n, 3);
		
		// Turn on K'th bit of a given number
		turnOnKBit(n, 4);
		
		// Find out Kth bit on or off
		findKthBit(n,4);
		
		//Toggle kth bit
		toggleKthBit(n,3);
		
		int x = 4, y = -5;
		System.out.println("two ints "+x+" and "+y+" have opposite sign or not? "+twoIntsOppositeSign(x, y));
		
		// swap two numbers
		swap(x, y);
		
	}
	
	private static void toggleKthBit(int n, int k) {
		System.out.println("Before toggle "+k+" bit of "+Integer.toBinaryString(n));
		n = n ^ (1 << (k-1));
		System.out.println("After toggle "+k+" bit of "+Integer.toBinaryString(n));
		
		
	}
	private static void findKthBit(int n, int k) {
		int tmp = n & (1<<(k-1));
		if(tmp > 0)
			System.out.println(k+" th bit of given number "+n+" is ON");
		else
			System.out.println(k+" th bit of given number "+n+" is OFF");
		 
	}
	private static void turnOnKBit(int n, int k) {
		System.out.println("Before Turn On "+k+" th bit "+Integer.toBinaryString(n));
			n = n | (1<< (k-1));
		System.out.println("After Turn On "+k+" th bit "+Integer.toBinaryString(n));
	}
	private static void turnOffKBit(int n, int k) {
		System.out.println("Before Turn Off "+k+" th bit "+Integer.toBinaryString(n));
		n = n & ~(1<<(k-1));
		System.out.println("After Turn Off "+k+" th bit "+Integer.toBinaryString(n));
	}
	private static void swap(int x , int y){
		System.out.println("before swap respectively: "+x+" : "+y);
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("After swap respectively: "+x+" : "+y);
	}
	private static int incrementOne(int i) {
		return -~i;
	}
	/*
	 * 1 - negetive
	 * 0 - positive
	 */
	private static boolean twoIntsOppositeSign(int i, int j) {
		
		return ((i^j) < 0)?true:false;
	}
	private static boolean isOddEven(int i) {
		return ((i&1)==1)?true:false;
	}
	
}
