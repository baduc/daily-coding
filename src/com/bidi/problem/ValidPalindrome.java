package com.bidi.problem;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * @author bidi
 *
 */
public class ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome3("A man, a plan, a canal: Panama") == true);
		System.out.println(isPalindrome3("race a car") == false);
	}

	private static String formatString(String s) {
		String formatedString = "";
		for (char c : s.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				formatedString += c;
			}
		}
		formatedString = formatedString.toLowerCase();
		return formatedString;
	}

	// 2 pointers from start to end
	public static boolean isPalindrome(String s) {

		String formatted = formatString(s);
		if (formatted.length() <= 1) {
			return true;
		}

		int start = 0;
		int end = formatted.length() - 1;

		while (start <= end) {
			if (formatted.charAt(start) != formatted.charAt(end)) {
				return false;
			}

			start++;
			end--;
		}

		return true;
	}

	// revered string == original
	public static boolean isPalindrome2(String s) {
		String formatted = formatString(s);

		if (formatted.length() <= 1) {
			return true;
		}

		String reversed = "";
		for (int i = formatted.length() - 1; i >= 0; i--) {
			reversed += formatted.charAt(i);
		}

		return reversed.equals(formatted);
	}

	// 2 pointers from the middle
	public static boolean isPalindrome3(String s) {
		String formatted = formatString(s);

		if (formatted.length() <= 1) {
			return true;
		}

		int start = formatted.length() / 2;
		int end = start;

		if (formatted.length() % 2 == 0) {
			start = start - 1;
		}

		while (start >= 0 && end <= formatted.length() - 1) {
			if (formatted.charAt(start) != formatted.charAt(end)) {
				return false;
			}
			start--;
			end++;
		}
		return true;
	}
}
