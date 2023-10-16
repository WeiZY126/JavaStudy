package com.study.LeetCode.algorithm11Bitwise;

/**
 * 汉明距离
 */
public class Test04LeetCode461 {
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int sum = 0;
        while (a != 0) {
            a = a & a - 1;
            sum++;
        }
        return sum;
    }
}
