package com.study.LeetCode.algorithm11Bitwise;

/**
 * 只出现一次的数字3
 */
public class Test03LeetCode260 {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        int a = 0;
        int b = 0;
        int k = (sum == Integer.MIN_VALUE) ? sum : sum & -sum;
        for (int num : nums) {
            //根据第一位不为1的数，分组异或
            if ((num & k) == 0) {
                a = a ^ num;
            } else {
                b = b ^ num;
            }
        }
        return new int[]{a, b};
    }
}
