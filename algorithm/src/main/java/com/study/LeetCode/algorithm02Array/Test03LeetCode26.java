package com.study.LeetCode.algorithm02Array;

/**
 * 删除有序数组中重复元素
 */
public class Test03LeetCode26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 1;
        int slowIndex = 0;
        int fastIndex = 1;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != nums[slowIndex]) {
                nums[++slowIndex] = nums[fastIndex++];
            } else {
                fastIndex++;
            }
        }
        return slowIndex+1;
    }
}
