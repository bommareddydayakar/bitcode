package com.equinix.algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionArrays {

	public static void main(String ar[]) {
		int[] s = {1,2,2,1,4};
		int[] t = {1,2,3};
		int[] tmp = intersection(s, t);
		for (int i : tmp) {
			System.out.println(i);
		}
	}

	private static int[] intersection(int[] s, int[] t) {
		Map<Integer, String> map = new HashMap<>();
		Set<Integer> list = new HashSet<Integer>();
		
		for (int i = 0; i < s.length; i++) {
			if(map.get(s[i]) == null){
				for (int j = 0; j < t.length; j++) {
					if(t[j] == s[i]){
						map.put(s[i], "");
						list.add(s[i]);
						break;
					}
				}
				if(	map.get(s[i]) == null){
					map.put(s[i],"");
				}
			}
		}
		
		int tmp[] = new int[list.size()], index = 0;
		for (Integer integer : list) {
			tmp[index++] = integer;
		}
		
		
		return tmp;
	}

}
