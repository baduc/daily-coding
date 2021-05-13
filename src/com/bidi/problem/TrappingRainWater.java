package com.bidi.problem;

/**
 * @author bidi
 *
 */
public class TrappingRainWater {
	public static void main(String[] args) {
		int[] t1 = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] t2 = new int[] { 4, 2, 0, 3, 2, 5 };

		System.out.println(trap(t2));
	}

	public static int trap(int[] height) {

		int total = 0;
		for (int i = 0; i < height.length; i++) {
			int maxLeft = height[i];
			int maxRight = height[i];
			int leftIdx = i;
			int rightIdx = i;
			while (leftIdx >= 0) {
				maxLeft = Math.max(maxLeft, height[leftIdx]);
				leftIdx--;
			}
			while (rightIdx <= height.length - 1) {
				maxRight = Math.max(maxRight, height[rightIdx]);
				rightIdx++;
			}
			total = total + Math.min(maxLeft, maxRight) - height[i];
		}
		return total;
	}
}
