package com.study.LeetCode.algorithm14DynamicProgramming;

/**
 * 不同路径
 */
public class Test04LeetCode62 {
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1)
            return 1;
        int[][] dpArr = new int[m][n];
        for (int i = 0; i < dpArr.length; i++) {
            for (int j = 0; j < dpArr[i].length; j++) {
                if (i == 0 || j == 0)
                    dpArr[i][j] = 1;
                else {
                    dpArr[i][j] = dpArr[i - 1][j] + dpArr[i][j - 1];
                }
            }
        }
        return dpArr[m - 1][n - 1];
    }
}
