package com.bidi.problem;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * 
 * @author bidi
 *
 */
public class MinimumRemoveToMakeValidParentheses {
	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)").equals("lee(t(c)o)de"));
		System.out.println(minRemoveToMakeValid("a)b(c)d").equals("ab(c)d"));
		System.out.println(minRemoveToMakeValid("))((").equals(""));
		System.out.println(minRemoveToMakeValid("(a(b(c)d)").equals("a(b(c)d)"));
	}

	public static String minRemoveToMakeValid2(String s) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty() || s.charAt(stack.peek()) == ')') {
					stack.push(i);
				} else {
					stack.pop();
				}
			}
		}

		StringBuilder sb = new StringBuilder(s);
		while (!stack.isEmpty()) {
			sb.deleteCharAt(stack.pop());
		}
		return sb.toString();
	}

	public static String minRemoveToMakeValid(String s) {
		char[] chars = s.toCharArray();
		int count = 0;

		// forward check: set blank value for extra closing paranthesis
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(')
				count++;
			else if (chars[i] == ')') {
				if (count == 0) {
					chars[i] = ' ';
				} else {
					count--;
				}
			}
		}

		count = 0;
		// reverse check: set blank value for extra opening paranthesis
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == ')')
				count++;
			else if (chars[i] == '(') {
				if (count == 0) {
					chars[i] = ' ';
				} else {
					count--;
				}
			}
		}

		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ')
				sb.append(chars[i]);
		}

		return sb.toString();
	}
}
