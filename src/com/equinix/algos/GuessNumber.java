package com.equinix.algos;

public class GuessNumber {
	public static void main(String[] args) {
		System.out.println(guessNumber(2126753390));
	}

	static int gN = 1702766719;
	// System.out.println(start+":"+mid+":"+end);

	public static int guessNumber(int n) {
		if (n == 1)
			return 1;

		long start = 1, end = n, mid = (start + end) / 2;

		while (start < end) {

			int gN = guess((int) mid);
			if (gN < 0) {
				end = mid;
			} else if (gN > 0) {
				start = mid;
			} else {
				return (int) mid;
			}
			if (start + 1 == end)
				return (guess((int) start) == 0) ? (int) start : (int) end;
			mid = (start + end) / 2;
		}
		return 0;
	}

	private static int guess(int mid) {

		if (mid < gN)
			return 1;
		else if (mid > gN)
			return -1;
		else
			return 0;
	}

	/*
	 * 2126753390 695097625:-736558140: -736558140:695097625:2126753390
	 */

}
