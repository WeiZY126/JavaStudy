package com.study.LeetCode.algorithm12Greedy;

import java.util.HashMap;

/**
 * 两数之和
 */
public class Test05LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer != null) {
                return new int[]{i, integer};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
