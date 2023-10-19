package com.study.LeetCode.algorithm14DynamicProgramming;

/**
 * 买卖股票的最佳时机含冷冻期
 */
public class Test09LeetCode309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //今日手中无股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今日手中有股票，前提是前一天不能为空窗期
            if (i >= 2) {
                //判断昨天是不是空窗期,即两天前持有，昨天卖掉，今天是空窗期，不能买入
                if (dp[i - 1][0] == dp[i - 2][1] + prices[i - 1]) {
                    dp[i][1] = Integer.MIN_VALUE;
                    continue;
                }
            }
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
