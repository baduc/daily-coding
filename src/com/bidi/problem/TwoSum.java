package com.bidi.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * 
 * @author bidi
 *
 *         Given an array of integers nums and an integer target, return indices
 *         of the two numbers such that they add up to target.
 * 
 *         You may assume that each input would have exactly one solution, and
 *         you may not use the same element twice.
 * 
 *         You can return the answer in any order.
 */
public class TwoSum {

	public static void main(String[] args) {

	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] { i, map.get(nums[i]) };
			} else {
				int numberToFind = target - nums[i];
				map.put(numberToFind, i);
			}
		}

		return null;
	}
}
