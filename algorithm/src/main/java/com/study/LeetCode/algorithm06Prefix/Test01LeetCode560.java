package com.study.LeetCode.algorithm06Prefix;

import java.util.HashMap;

/**
 * 和为K的子数组
 */
public class Test01LeetCode560 {
    public static void main(String[] args) {
        new Test01LeetCode560().subarraySum(new int[]{1, 1, 1}, 2);
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int prefix = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            prefix += num;
            int i = prefix - k;
            if (i == 0)
                res++;
            res += hashMap.getOrDefault(i, 0);
            hashMap.put(prefix, hashMap.getOrDefault(prefix, 0) + 1);
        }
        return res;

    }
}
