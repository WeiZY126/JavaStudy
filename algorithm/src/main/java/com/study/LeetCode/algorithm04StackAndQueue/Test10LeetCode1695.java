package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.HashSet;

/**
 * 删除子数组的最大得分
 */
public class Test10LeetCode1695 {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxNum = 0;
        int tempNum = 0;
        while (right < nums.length) {
            int num = nums[right];
            //当窗口中出现重复值
            while (set.contains(num)) {
                int num1 = nums[left];
                set.remove(num1);
                //向右收缩窗口
                left++;
                tempNum -= num1;
            }
            set.add(num);
            tempNum += num;
            maxNum = Math.max(tempNum, maxNum);
            right++;
        }
        return maxNum;
    }
}
