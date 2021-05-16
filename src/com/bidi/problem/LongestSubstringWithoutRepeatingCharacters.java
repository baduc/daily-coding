package com.bidi.problem;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author bidi
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String t1 = "abcabcbb";
		String t2 = "bbbbb";
		String t3 = "pwwkew";
		String t4 = " ";
		String t5 = "abcbdca";
		String t6 = "abcbdaac";

		System.out.println(lengthOfLongestSubstring(t1) == 3);
		System.out.println(lengthOfLongestSubstring(t2) == 1);
		System.out.println(lengthOfLongestSubstring(t3) == 3);
		System.out.println(lengthOfLongestSubstring(t4) == 1);
		System.out.println(lengthOfLongestSubstring(t5) == 4);
		System.out.println(lengthOfLongestSubstring(t6) == 4);
	}

	// sliding window O(n) optimal
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1)
			return s.length();

		int maxLength = 0;
		Map<Character, Integer> seenChars = new LinkedHashMap<>();
		int left = 0;

		for (int right = 0; right < s.length(); right++) {
			char currentChar = s.charAt(right);
			Integer preIndexChar = seenChars.get(currentChar);

			if (preIndexChar != null && preIndexChar >= left) {
				left = preIndexChar + 1;
			}
			seenChars.put(currentChar, right);
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	// brute force O(n2)
	public static int lengthOfLongestSubstring2(String s) {
		int maxLength = 0;
		Set<Character> seenChars = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (!seenChars.contains(s.charAt(j))) {
					seenChars.add(s.charAt(j));
					maxLength = Math.max(maxLength, seenChars.size());
				} else {
					seenChars.clear();
					break;
				}
			}
		}
		return maxLength;
	}

	// interesting solution
	public static int lengthOfLongestSubstring3(String s) {
		int i = 0, j = 0, maxLength = 0;
		Set<Character> set = new HashSet<>();
		while (i < s.length()) {
			if (!set.contains(s.charAt(i))) {
				set.add(s.charAt(i));
				i++;
				maxLength = maxLength > set.size() ? maxLength : set.size();
			} else {
				set.remove(s.charAt(j));
				j++;
			}
		}
		return maxLength;
	}

}
