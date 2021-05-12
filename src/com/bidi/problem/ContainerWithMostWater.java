package com.bidi.problem;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * @author bidi
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] t1 = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int[] t2 = new int[] { 1, 1 };
		int[] t3 = new int[] { 4, 3, 2, 1, 4 };
		int[] t4 = new int[] { 1, 2, 1 };

		System.out.println(maxArea(t1));
	}

	public static int maxArea(int[] height) {
		int low = 0;
		int high = height.length - 1;

		int max = 0;
		while (low < high) {
			final int min = Math.min(height[low], height[high]);
			final int area = min * (high - low);
			if (max < area) {
				max = area;
			}
			if (min == height[low])
				low++;
			if (min == height[high])
				high--;
		}

		return max;
	}
}
