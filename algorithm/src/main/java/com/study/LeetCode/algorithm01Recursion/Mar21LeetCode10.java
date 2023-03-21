package com.study.LeetCode.algorithm01Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列*
 * 同LeetCode70*
 * 写一个函数，输入n，求斐波那契数列的第n项*
 * 热度 京东*
 */
public class Mar21LeetCode10 {
    /*递归*/
    private Map<Integer, Integer> storeMap = new HashMap<>();

    public int Leetcode10Recursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (storeMap.get(n) != null) {
            return storeMap.get(n);
        } else {
            int res = Leetcode10Recursion(n - 2) + Leetcode10Recursion(n - 1);
            storeMap.put(n, res);
            return res;
        }
    }

    /*循环*/
    public int leetCode100Circulate(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int sum = 0;
        int lastSum = 1;
        int lastLastSum = 0;
        for (int i = 3; i <= n; i++) {
            sum = lastSum + lastLastSum;
            lastLastSum = lastSum;
            lastSum = sum;
        }
        return sum;

    }
}
