package com.study.LeetCode.algorithm02Array;

/**
 * 移动零*
 */
public class Test01LeetCode283 {
    /*挪动双指针*/
    public void leetCode283(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int slowIndex = 0;
        int fastIndex = 0;

        while (fastIndex < nums.length) {
            if (nums[fastIndex++] == 0) {
                continue;
            } else {
                nums[slowIndex++] = nums[fastIndex++];
            }
        }
        while (slowIndex < nums.length) {
            nums[slowIndex++] = 0;
        }
    }
}
