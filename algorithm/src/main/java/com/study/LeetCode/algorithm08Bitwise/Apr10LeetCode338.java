package com.study.LeetCode.algorithm08Bitwise;

/**
 * 比特位计数*
 */
public class Apr10LeetCode338 {
    //M&(M-1)解法
    public int[] leetCode338(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    //奇偶性解决
    public int[] leetCode338OddEven(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = (i & 1) != 0 ? res[i >> 1] + 1 : res[i >> 1];
        }
        return res;
    }
}
