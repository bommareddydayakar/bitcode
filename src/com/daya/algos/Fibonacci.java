package com.daya.algos;

public class Fibonacci {
	public static void main(String[] args) {
		//fibRec(100);
		//System.out.println(getFibonacciRec(10));
		System.out.println(0);
		System.out.println(1);
		
		fibRec(0,1,10);
	}
	private static void fibRec(int a, int b,int n){
		if(n<0)
			System.out.println("Invalid entry to generate Fibonacci");
		else if(n==0 || n==1)
			System.out.println(n);
		else{
				int i = a+b;
				a= b;
				b = i;
				if(i<=n){
					System.out.println(i);
					fibRec(a, b, n);
				}
				
		}
		
	}
	private static void fibRec(int n){
		if(n<0)
			System.out.println("Invalid entry to generate Fibonacci");
		else if(n==0 || n==1)
			System.out.println(n);
		else{
			int a=0,b=1;
			System.out.println(a);
			System.out.println(b);
			
			while(true){
				int i = a+b;
				a= b;
				b = i;
				if(i>n) break;
				System.out.println(i);
			}
		}
		
	}
	 public static int getFibonacciRec(int n) {
		 if(n < 0) {
		 throw new IllegalArgumentException("n cannot be negative!" );
		 }
		 if(n == 0 || n == 1) 
		 return n;
		 return getFibonacciRec(n-1) + getFibonacciRec(n-2);
		 }
	
}
