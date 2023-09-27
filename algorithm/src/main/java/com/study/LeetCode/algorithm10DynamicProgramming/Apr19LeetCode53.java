package com.study.LeetCode.algorithm10DynamicProgramming;

/**
 * 最大子序和*
 */
public class Apr19LeetCode53 {
    public static int LeetCode53(int[] nums){
        int maxRes = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            if (dp[i]>maxRes)
                maxRes = dp[i];
        }
        return maxRes;
    }

    public static int LeetCode53withOutArray(int[] nums){
        int maxRes = nums[0];
        int lastValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lastValue = Math.max(nums[i],nums[i]+lastValue);
            if (lastValue>maxRes)
                maxRes = lastValue;
        }
        return maxRes;
    }
}
