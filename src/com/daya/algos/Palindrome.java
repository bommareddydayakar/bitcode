package com.daya.algos;

public class Palindrome {

	public static void main(String[] args) {
		// String s = "Red rum, sir, is murder";
		String s = "0P0";
		System.out.println(isPalindrome(s));
	}

	private static boolean isPalindrome(String s) {
		if (s == null)
			return false;
		if (s.length() == 0)
			return true;
		char[] cArr = s.toCharArray();
		int start = 0, end = s.length() - 1;
		String alphaNum = "0123456789abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVXYZ";
		while (start <= end) {
			int sInt = cArr[start];
			int eInt = cArr[end];

			if (alphaNum.indexOf(cArr[start]) < 0) {
				start++;
				continue;
			}

			if (alphaNum.indexOf(cArr[end]) < 0) {
				end--;
				continue;
			}
		
			if (sInt == eInt || 
					(
							(
								(sInt > 64 && sInt < 91) || 
								(sInt > 96 && sInt < 123)
							) &&			
							(Math.abs(sInt - eInt) == 0 || Math.abs(sInt - eInt) == 32)
					)
				) {
				start++;
				end--;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
