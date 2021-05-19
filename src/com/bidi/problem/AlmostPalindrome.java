package com.bidi.problem;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * 
 * @author bidi
 *
 */
public class AlmostPalindrome {

	public static void main(String[] args) {
		System.out.println(validPalindrome("aba") == true);
		System.out.println(validPalindrome("abca") == true);
		System.out.println(validPalindrome("abc") == false);
		System.out.println(validPalindrome("radcaeacar") == true);
	}

	public static boolean validPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
			}

			start++;
			end--;
		}
		return true;
	}

	private static boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}

			start++;
			end--;
		}
		return true;
	}
}
