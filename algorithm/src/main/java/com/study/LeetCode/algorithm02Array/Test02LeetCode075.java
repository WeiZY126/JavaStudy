package com.study.LeetCode.algorithm02Array;

public class Test02LeetCode075 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int index = 0;
        int leftIndex = 0;
        int rightIndex = nums.length;
        while (index <= rightIndex) {
            if (nums[index] == 0) {
                int temp = nums[index];
                nums[index++] = nums[leftIndex];
                nums[leftIndex++] = temp;
            } else if (nums[index] == 1) {
                index++;
            } else {
                int temp = nums[index];
                nums[index++] = nums[rightIndex];
                nums[rightIndex--] = temp;
            }
        }
    }
}
