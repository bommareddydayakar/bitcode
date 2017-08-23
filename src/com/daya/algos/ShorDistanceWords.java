package com.equinix.algos;

public class ShorDistanceWords {

	public static void main(String ar[]) {
		
		String words[] = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding", word2 = "practice";
		//String word1 = "makes",	word2 = "coding";
		
		System.out.println(shortestDistance(words, word1, word2));
	}
	public static int shortestDistance(String[] words, String word1, String word2) {
		int distance = 0;
		if(words == null || words.length==0 || word1==null || word2 == null)
			return distance;
		else{
			
			int start = 0,end=words.length-1;
			String searchWord = null;
			int[] w1Arr = new int[end+1];
			int[] w2Arr = new int[end+1];
			int index1 = 0, index2 = 0;
			distance = end*end;
			while(start<end){
				if(words[start].equals(word1)){
					w1Arr[index1++] = start+1;
				}else if(words[start].equals(word2)){
					w2Arr[index2++] = start+1;
				}
				if(words[end].equals(word1)){
					w1Arr[index1++] = end+1;
				}if(words[end].equals(word2)){
					w2Arr[index2++] = end+1;
				}
				start++;end--;
			}
			
			for (int i = 0;  i< w1Arr.length; i++) {
				for (int j = 0; j < w2Arr.length; j++) {
					if( w1Arr[i] !=0 && w2Arr[j] != 0 && distance > Math.abs(w1Arr[i]-w2Arr[j])){
						distance = Math.abs(w1Arr[i]-w2Arr[j]);
					}
				}
			}
		}
		
		return distance;
	}
	
}
