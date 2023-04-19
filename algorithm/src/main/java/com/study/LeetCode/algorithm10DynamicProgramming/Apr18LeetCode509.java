package com.study.LeetCode.algorithm10DynamicProgramming;

/**
 * 斐波那契数列*
 */
public class Apr18LeetCode509 {
    public static int LeetCode509(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
