package com.study.LeetCode.algorithm10Math;

/**
 * 整数反转
 */
public class Test04LeetCode7 {
    public int reverse(int x) {
        if (x == 0)
            return 0;
        int res = 0;
        while (x != 0) {
            int i = x % 10;
            if (res > 214748364 || res < -214748364) {
                if (x > 0) {
                    if (!(res == 214748364 && i < 7))
                        return 0;
                } else {
                    if (!(res == 214748364 && i < 8))
                        return 0;
                }
            }
            res *= 10;
            res += i;
            x = x / 10;
        }
        return res;
    }
}
