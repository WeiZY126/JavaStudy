package com.study.LeetCode.algorithm14DynamicProgramming;

/**
 * 买卖股票的最佳时机 IV
 */
public class Test08LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        //定义三维数组
        int[][][] dp = new int[days][k + 1][2];

        for (int i = 1; i < k; i++) {
            //此时至多进行i次交易
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        //遍历
        for (int i = 1; i < days; i++) {
            for (int j = 1; j <= k; j++) {
                //两种情况
                //当天持有股票为0
                //则说明前天不持有,今天也不购买。或者前天持有，今天卖出
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                //当天持有股票为1
                //则说明前天买入了，今天没买。或者前天没有持有股票，今天新买入
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        //最后一天肯定不持有，如果持有说明还没卖出
        return dp[days - 1][k][0];
    }
}
