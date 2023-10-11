package com.study.LeetCode.algorithm07TwoIndex;

/**
 * x的平方根
 */
public class Test04LeetCode69 {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int res = -1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid * mid > x)
                r = mid - 1;
            else {
                l = mid + 1;
                res = mid;
            }
        }
        return res;
    }
}
