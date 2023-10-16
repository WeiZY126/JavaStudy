package com.study.LeetCode.algorithm11Bitwise;

/**
 * 丢失的数字
 */
public class Test05LeetCode268 {
    public int missingNumber(int[] nums) {
        int missing = 0;

        for (int i = 0; i < nums.length; i++) {
            missing = missing ^ nums[i] ^ i + 1;
        }
        return missing;
    }
}
