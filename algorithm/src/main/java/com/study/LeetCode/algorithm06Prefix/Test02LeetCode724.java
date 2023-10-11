package com.study.LeetCode.algorithm06Prefix;

public class Test02LeetCode724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (sum - prefix - cur == 0)
                return i;
            sum -= cur;
            prefix += cur;
        }
        return nums.length - 1;
    }
}
