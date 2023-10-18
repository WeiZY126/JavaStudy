package com.study.LeetCode.algorithm12Greedy;

import java.util.Arrays;

/**
 * 分发饼干
 */
public class Test01LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < g.length && j < s.length) {
            if (g[i] > s[j]) {
                j++;
            } else {
                res++;
                i++;
                j++;
            }
        }
        return res;
    }
}
