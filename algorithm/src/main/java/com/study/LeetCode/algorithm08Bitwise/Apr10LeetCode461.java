package com.study.LeetCode.algorithm08Bitwise;

/**
 * 汉明距离
 * 对应二进制位不同的位置的数目* *
 */
public class Apr10LeetCode461 {
    public static int LeetCode461(int x, int y) {
        int res = 0;
        for (int i = x ^ y; i != 0; i = i & (i - 1)) {
            res++;
        }
        return res;
    }

}
