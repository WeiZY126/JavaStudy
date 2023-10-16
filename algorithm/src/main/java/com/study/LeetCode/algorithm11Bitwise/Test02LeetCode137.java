package com.study.LeetCode.algorithm11Bitwise;

/**
 * 只出现一次的数字2
 */
public class Test02LeetCode137 {
    public int singleNumber(int[] nums) {
        int[] ints = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                int temp = num >> i;

                int x = temp & 1;
                if (x == 1)
                    ints[i]++;
            }
        }

        int res = 0;
        for (int i = 0; i < ints.length; i++) {
            int temp = ints[i] % 3;
            if (temp == 1) {
                res += 1 << i;
            }
        }
        return res;
    }
}
