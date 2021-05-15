package com.bidi.problem;

import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 * 
 * @author bidi
 *
 */
public class BackspaceStringCompare {

	public static void main(String[] args) {
		String s1 = "ab#c";
		String t1 = "ad#c";
		String s2 = "ab##";
		String t2 = "c#d#";
		String s3 = "a##c";
		String t3 = "#a#c";
		String s4 = "a#c";
		String t4 = "b";

		System.out.println(backspaceCompare(s1, t1) == true);
		System.out.println(backspaceCompare(s2, t2) == true);
		System.out.println(backspaceCompare(s3, t3) == true);
		System.out.println(backspaceCompare(s4, t4) == false);

	}

	// brute force
	public static boolean backspaceCompare(String s, String t) {
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();

		Stack<Character> stack1 = new Stack<Character>();
		for (char c : sChars) {
			if (c != '#') {
				stack1.push(c);
			} else {
				if (!stack1.isEmpty()) {
					stack1.pop();
				}
			}
		}
		String sConvert = String.valueOf(stack1);
		
		Stack<Character> stack2 = new Stack<Character>();
		for (char c : tChars) {
			if (c != '#') {
				stack2.push(c);
			} else {
				if (!stack2.isEmpty()) {
					stack2.pop();
				}
			}
		}
		String tConvert = String.valueOf(stack2);

		return sConvert.equals(tConvert);
	}

}
