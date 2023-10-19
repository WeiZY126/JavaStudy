package com.study.LeetCode.algorithm14DynamicProgramming;

/**
 * 买卖股票的最佳时机 II
 */
public class Test06LeetCode122 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        int sale = 1;
        while (sale < prices.length) {
            if (prices[sale] < prices[sale - 1]) {
                maxProfit = maxProfit + (prices[sale - 1] - prices[buy]);
                buy = sale;
            }
            sale++;
        }
        if (buy != sale - 1) {
            maxProfit += (prices[sale - 1] - prices[buy]);
        }
        return maxProfit;
    }
}
