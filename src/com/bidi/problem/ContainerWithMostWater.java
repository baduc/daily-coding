package com.bidi.problem;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * @author bidi
 * 
 *         Given n non-negative integers a1, a2, ..., an , where each represents
 *         a point at coordinate (i, ai). n vertical lines are drawn such that
 *         the two endpoints of the line i is at (i, ai) and (i, 0). Find two
 *         lines, which, together with the x-axis forms a container, such that
 *         the container contains the most water.
 * 
 *         Notice that you may not slant the container.
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
