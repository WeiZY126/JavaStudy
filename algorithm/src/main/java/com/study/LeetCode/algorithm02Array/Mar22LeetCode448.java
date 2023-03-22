package com.study.LeetCode.algorithm02Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字*
 */
public class Mar22LeetCode448 {
    /*置为负数*/
    public List<Integer> leetCode448Negative(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            if (j > 0) {
                if (nums[j - 1] > 0)
                    nums[j - 1] = -nums[j - 1];
            } else {
                if (nums[-j - 1] > 0)
                    nums[-j - 1] = -nums[-j - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }

    /*取模*/
    public List<Integer> leetCode448Division(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //需要先-1再取模，遇到length相等的值时取模后减一会变成-1
            int n = (nums[i] - 1) % length;
            nums[n] += length;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] <= length)
                list.add(i + 1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Mar22LeetCode448().leetCode448Division(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
