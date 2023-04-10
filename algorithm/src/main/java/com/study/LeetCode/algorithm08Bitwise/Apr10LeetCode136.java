package com.study.LeetCode.algorithm08Bitwise;

/**
 * 只出现一次的数字*
 */
public class Apr10LeetCode136 {
    public int leetCode136(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
