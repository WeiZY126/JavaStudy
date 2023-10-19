package com.study.LeetCode.algorithm14DynamicProgramming;

/**
 * 爬楼梯
 */
public class Test02LeetCode70 {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        //第一层有一种办法
        int p = 1;
        //第二层有两种办法
        int q = 2;
        for (int i = 3; i <= n; i++) {
            //第i层就有[i-1]+[i-2]种办法
            int temp = p + q;
            p = q;
            q = temp;
        }
        return q;
    }
}
