package com.study.LeetCode.algorithm02Array;

/**
 * 移动零*
 */
public class Mar22LeetCode283 {
    /*挪动双指针*/
    public void leetCode283(int[] nums) {
        if (nums == null && nums.length == 0)
            return;
        int j = 0;
        //第一次遍历时，j记录非0的个数，只要是非0的数都赋给nums[j]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //置0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
