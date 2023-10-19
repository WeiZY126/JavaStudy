package com.study.LeetCode.algorithm14DynamicProgramming;

/**
 * 买卖股票的最佳时机
 */
public class Test05LeetCode121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            if (price > minPrice) {
                maxProfit = Math.max(maxProfit, price - minPrice);
            } else {
                minPrice = price;
            }
        }
        return maxProfit;
    }
}
