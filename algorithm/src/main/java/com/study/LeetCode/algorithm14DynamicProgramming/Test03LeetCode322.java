package com.study.LeetCode.algorithm14DynamicProgramming;

import java.util.Arrays;

/**
 * 零钱兑换
 */
public class Test03LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dpArr = new int[amount + 1];
        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
        }
        for (int i = 1; i < dpArr.length; i++) {
            for (int coin : coins) {
                if (coin == i) {
                    dpArr[i] = 1;
                    break;
                } else if (coin > i) {
                    continue;
                } else {
                    if (dpArr[i - coin] == -1)
                        continue;
                    int num = 1 + dpArr[i - coin];
                    if (dpArr[i] == -1 || num < dpArr[i])
                        dpArr[i] = num;
                }
            }
        }
        return dpArr[amount];
    }
}
