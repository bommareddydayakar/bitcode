package com.equinix.algos;

public class Candy {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 3,2,1,0 };
		// System.out.println(
		candy(arr);// );
	}

	public static int candy(int[] arr) {
		int minCandy = 0;
		int[] ra = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 && arr[i] > arr[i + 1]) {
				ra[i] = 2;
			} else if (i > 0 && arr[i] > arr[i - 1]) {
				ra[i] = ra[i - 1] + 1;
			} else if (i > 0 && arr[i] == arr[i - 1]) {
				ra[i] = ra[i - 1];
			} else {
				ra[i] = 1;
			}
		}
		for (int i = arr.length-1; i > -1; i--) {
			if (i == arr.length-1 && arr[i] < arr[i - 1]) {
				ra[i-1] = ra[i-1]+1;
			} else if (i < arr.length-1 && arr[i] > arr[i - 1]) {
				ra[i] = ra[i - 1] + 1;
			} else if (i > 0 && arr[i] == arr[i - 1]) {
				ra[i] = ra[i - 1];
			} else {
				ra[i] = 1;
			}
		}

		for (int i : ra) {
			System.out.println(i);
		}
		return minCandy;
	}
}
