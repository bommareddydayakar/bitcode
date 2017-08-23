package com.equinix.algos.dynamicprog;

public class CuttingRod {
	public static void main(String[] args) {
		//int price[] = {1,5,8,9,10,17,17,20};
		//int price[] = {3,8};
		int price[] = {3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8,3,2,5,6,11,10,9,8};
		int result[] = new int[price.length+1];
		result[0] = 0; 
		System.out.println(System.currentTimeMillis());
		System.out.println("Max price can be DP Memoization:"+ cutRod(price,price.length,result));
		System.out.println(System.currentTimeMillis());
		System.out.println("Max price can be DP Simple:"+cutRodSimple(price));
		System.out.println(System.currentTimeMillis());
		System.out.println("Max price can be recursion:"+ cutRod(price,price.length));
		System.out.println(System.currentTimeMillis());
	}

	private static int cutRod(int[] price, int length) {
		if(length <= 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i< length;i++){
			max = Math.max(max, price[i]+cutRod(price, length-i-1));
		}
		return max;
	}
	private static int cutRod(int[] price, int length,int[] result) {
		if(length <= 0)
			return 0;
		int max = Integer.MIN_VALUE;
		if(result[length] > 0)
			return result[length];
		for(int i=0; i< length;i++){
			max = Math.max(max, price[i]+cutRod(price, length-i-1,result));
		}
		result[length] = max;
		return result[length];
	}
	
	private static int cutRodSimple(int[] price) {
		int len = price.length;
		int val[] = new int[len];
		if(len == 0)
			return 0;
		
		val[0] = price[0];
		if(len ==1 ){
			return price[0];
		}
		else{
			for(int i=1;i<len;i++){
				val[i] = val[i-1]+val[0];
			}
		}
		
		return val[len-1];
	}
	
	
	
	
}
