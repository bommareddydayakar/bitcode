package com.daya.algos;

public class WordReverse {
	public static void main(String[] args) {
		String s = "Hello world of algorithms";
		System.out.println(reverse(s.toCharArray()));
	}

	public static char[] reverse(char[] sArr) {
		int i = 0;
		for (int j = 0; j < sArr.length; j++) {
			if (sArr[j] == ' ') {
				reverseWord(sArr, i, j - 1);
				i = j + 1;
			}
		}
		reverseWord(sArr, i, sArr.length-1);
		reverseWord(sArr, 0, sArr.length-1);
		
		return sArr;
	}

	private static void reverseWord(char[] sArr, int i, int j) {
		while (i < j) {
			sArr[i] += sArr[j];
			sArr[j] = (char) (sArr[i] - sArr[j]);
			sArr[i] = (char) (sArr[i] - sArr[j]);
			i++;j--;
		}

	}

	private static void swap(int[] arr, int i, int j) {
		arr[i] += arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}
}
