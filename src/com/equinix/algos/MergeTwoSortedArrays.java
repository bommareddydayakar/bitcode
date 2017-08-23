package com.equinix.algos;

public class MergeTwoSortedArrays {

	public static void main(String ar[]) {
		int[] s = new int[6];
		s[0] = 4;
		// s[1] = 5;
		/*
		 * s[2] = 12; s[3] = 13; s[4] = 14;
		 */
		int[] t = { 1, 2, 3, 5, 6 };
		// int[] t = {1,2};
		long start = System.currentTimeMillis();
		merge(s, 1, t, 5);
		System.out.println("-->"+(System.currentTimeMillis()-start));
		for (int i : s) {
			System.out.println(i);
		}
	}

	private static void merge(int[] s, int sLen, int[] t, int tLen) {

		int i = 0, j = 0, newLen = sLen;
		while (i < newLen && j < tLen) {
			if (s[i] > t[j]) {
				for (int ind = newLen++; ind > i; ind--) {
					s[ind] = s[ind - 1];
				}
				s[i++] = t[j++];
			} else {
				i++;
			}
		}
		int k = tLen - 1;
		int h = s.length - 1;
		while (k >= j) {
			s[h--] = t[k--];
		}

	}

}
