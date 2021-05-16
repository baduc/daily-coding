package com.bidi.problem;

import java.util.LinkedHashMap;
import java.util.Map;

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

		System.out.println(lengthOfLongestSubstring(t1) == 3);
		System.out.println(lengthOfLongestSubstring(t2) == 1);
		System.out.println(lengthOfLongestSubstring(t3) == 3);
		System.out.println(lengthOfLongestSubstring(t4) == 1);
		System.out.println(lengthOfLongestSubstring(t5) == 4);
	}

	// brute force O(n2)
	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		for (int i = 0; i < s.length(); i++) {
			Map<Character, Integer> map = new LinkedHashMap<>();
			for (int j = i; j < s.length(); j++) {
				if (!map.containsKey(s.charAt(j))) {
					map.put(s.charAt(j), 1);
					maxLength = Math.max(maxLength, map.size());
				} else {
					break;
				}
			}
		}
		return maxLength;
	}

}
