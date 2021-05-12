package com.bidi.problem;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		
	}
	
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
               return new int[] {i, map.get(nums[i])};
            } else {
                int numberToFind = target - nums[i];
                map.put(numberToFind, i);
            }
        }
        
        return null;
    }
}
