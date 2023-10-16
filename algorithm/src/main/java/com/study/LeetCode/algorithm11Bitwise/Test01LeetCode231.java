package com.study.LeetCode.algorithm11Bitwise;

public class Test01LeetCode231 {
    public boolean isPowerOfTwo(int n) {
        if (n > 0) {
            return (n & (n - 1)) == 0;
        }
        return false;
    }
}
