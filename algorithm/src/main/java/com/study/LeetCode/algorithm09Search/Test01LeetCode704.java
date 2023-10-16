package com.study.LeetCode.algorithm09Search;

/**
 * 二分查找
 */
public class Test01LeetCode704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                //如果当前值大于目标值
                right = mid - 1;
            } else {
                //如果当前值小于目标值
                left = mid + 1;
            }
        }
        return -1;
    }
}
