package com.study.LeetCode.algorithm06Prefix;

/**
 * 长度最小的子数组
 */
public class Test03LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLength = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                int length = right - left + 1;
                if (minLength == 0 || length < minLength) {
                    minLength = length;
                }
                sum -= nums[left++];
            }
            right++;
        }
        return minLength;
    }
}
