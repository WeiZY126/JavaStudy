package com.study.LeetCode.algorithm10DynamicProgramming;

/**
 * 买卖股票的最佳时机*
 */
public class Apr19LeetCode121 {
    public static int LeetCode121(int[] prices) {
        int minValue = prices[0];
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(prices[i] - minValue, dp[i - 1]);
            if (prices[i] < minValue) minValue = prices[i];
        }
        return dp[dp.length];
    }

    public static int LeetCode121withoutArray(int[] prices) {
        int minValue = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - minValue, profit);
            if (prices[i] < minValue) minValue = prices[i];
        }
        return profit;
    }
}
