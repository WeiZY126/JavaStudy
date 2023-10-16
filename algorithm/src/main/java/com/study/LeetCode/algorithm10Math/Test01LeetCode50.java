package com.study.LeetCode.algorithm10Math;

/**
 * Pow(x,n)
 */
public class Test01LeetCode50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = myPow(x, n / 2);
        //n为偶数
        if (n % 2 == 0) {
            return y * y;
        } else {
            //n为负数，或n为奇数
            if (n > 0) {
                return y * y * x;
            } else {
                return y * y * (1.0 / x);
            }
        }
    }
}
