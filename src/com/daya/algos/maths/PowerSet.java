package com.equinix.algos.maths;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	public static void main(String[] args) {
		char set[] =  {'z','a','b','c','d'};
		//char set[] =  {'1','2','3'};
		//powerSet(set);
		//System.out.println(powerSetIterative(set));
		powerSet(set);
		System.out.println(~(~5));
		System.out.println(5*-1);
		System.out.println(5/-1);
		
		
	}
	private static List<String> powerSetIterative(char[] set) {
		List<String> ps = new ArrayList<String>();
		
		ps.add("{}");
		for (int i = 0; i < set.length; i++) {
			int size = ps.size();
			for (int j = 0; j < size; j++) {
				String tmp = ps.get(j);
				if("{}".equals(tmp))
					tmp = tmp.replace("}", set[i]+"}");
				else
					tmp = tmp.replaceAll("}", ","+set[i]+"}");
				ps.add(tmp);
			}
		}
		return ps;
		
		
		
	}
	private static int power(int n, int times){
		if(times <=0)
			return 1;
		if(times==1)
			return n;
		if(times%2 ==0)
			return power(n,times/2)*power(n,times/2);
		else
			return power(n,times/2)*power(n,times/2)*n;
	}
	
	
	//char set[] =  {'z','a','b','c','d'};
	
	private static void powerSet(char[] set) {
		
		int power = power(2,set.length); // will give square of the given number.
		System.out.println(power);
		for (int i = 0; i < power; i++) {
			System.out.print("{");
			for (int j = 0; j < set.length; j++) {
				//System.out.println(i+":"+power(2,j) +":"+ (i& (power(2,j))));
				if((i& (power(2,j))) > 0){
					System.out.print(set[j]+" ");
				}
			}
			System.out.println("}");
			
		}
		
	}
}
