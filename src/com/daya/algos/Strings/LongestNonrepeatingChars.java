package com.daya.algos.Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestNonrepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character,Integer>(); 
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);//1,3,4,5,6
            }
            ans = Math.max(ans, j - i + 1);//1,2,3,3,3,3
            map.put(s.charAt(j), j + 1);//a-4,b-5,c-6,a-4,b-5,c-6,
        }
        return ans;
    }
    
    public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcc"));
	}
}