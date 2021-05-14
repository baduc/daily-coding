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

	//O(n)
	public static int trap(int[] height) {
		int total = 0;
		int left = 0;
		int right = height.length - 1;

		int maxLeft = height[left];
		int maxRight = height[right];
		while (left < right) {
			if (height[left] <= height[right]) {
				if (maxLeft < height[left]) {
					maxLeft = height[left];
				} else {
					total += maxLeft - height[left];
				}
				left++;
			} else {
				if (maxRight < height[right]) {
					maxRight = height[right];
				} else {
					total += maxRight - height[right];
				}
				right--;
			}
		}

		return total;
	}

	//O(n^2)
	public static int trap2(int[] height) {

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
			int curWater = Math.min(maxLeft, maxRight) - height[i];
			if (curWater > 0) {
				total = total + curWater;
			}
		}
		return total;
	}
}
