package com.study.LeetCode.algorithm14DynamicProgramming;

/**
 * 斐波那契数
 */
public class Test01LeetCode509 {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
