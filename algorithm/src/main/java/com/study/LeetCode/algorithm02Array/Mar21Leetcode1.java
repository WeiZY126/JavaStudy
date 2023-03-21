package com.study.LeetCode.algorithm02Array;

import java.util.HashMap;

/**
 * 两数之和
 * 热度 字节、美团、BAT、京东* *
 */
public class Mar21Leetcode1 {
    /*暴力穷举O(n^2)*/
    public int[] leetCode001BF(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i + j == target) {
                    result[0] = i;
                    result[1] = j;
                }
                return result;
            }
        }
        return result;
    }

    /*hashmap方法O(n)*/
    public int[] leetCode001HashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer j = hashMap.get(target - nums[i]);
            if (j != null) {
                result[1] = i;
                result[0] = j;
                return result;
            } else
                hashMap.put(nums[i], j);
        }
        return result;
    }
}
