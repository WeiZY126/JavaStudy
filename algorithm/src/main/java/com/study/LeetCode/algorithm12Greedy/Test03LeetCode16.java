package com.study.LeetCode.algorithm12Greedy;

import java.util.Arrays;

/**
 * 最接近的三数之和
 */
public class Test03LeetCode16 {
    public static void main(String[] args) {
        new Test03LeetCode16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int res = 0;
        int num = Integer.MAX_VALUE;
        //三数之和
        while (i <= nums.length - 3) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target)
                    return sum;
                int temp = Math.abs(target - sum);
                if (temp < num) {
                    res = sum;
                    num = temp;
                }
                if (sum > target)
                    right--;
                else
                    left++;
            }
            i++;
        }
        return res;
    }
}
