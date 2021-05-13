package com.bidi.problem;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * @author bidi
 *
 *         Given an array of integers numbers that is already sorted in
 *         ascending order, find two numbers such that they add up to a specific
 *         target number.
 * 
 *         Return the indices of the two numbers (1-indexed) as an integer array
 *         answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
 * 
 *         You may assume that each input would have exactly one solution and
 *         you may not use the same element twice.
 * 
 */
public class TwoSumSortedArray {

	public static void main(String[] args) {
		int[] t1 = new int[] { 2, 7, 11, 15 };
		int k1 = 9;

		int[] t2 = new int[] { 2, 3, 4 };
		int k2 = 6;

		int[] t3 = new int[] { -1, 0 };
		int k3 = -1;

		int[] twoSum = twoSum(t3, k3);
		System.out.println(twoSum[0]);
		System.out.println(twoSum[1]);
	}

	public static int[] twoSum(int[] numbers, int target) {

		int low = 1;
		int high = numbers.length;

		while (low < high) {
			int sum = numbers[low - 1] + numbers[high - 1];
			if (sum == target) {
				return new int[] { low, high };
			} else if (sum > target) {
				high--;
			} else {
				low++;
			}

		}

		return null;
	}
}
