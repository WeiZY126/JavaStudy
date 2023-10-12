package com.study.LeetCode.algorithm09Search;

/**
 * 二分查找*
 */
public class Apr10LeetCode704 {
    //循环迭代方式
    public static int leetCode704Circulate(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int leetCode704Recursion(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        return recursion(nums,target,left,right);
    }

    public static int recursion(int[] nums, int target, int left, int right) {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target)
            return recursion(nums, target, mid + 1, right);
        else
            return recursion(nums, target, left, mid - 1);
    }

    public static void main(String[] args) {
        leetCode704Circulate(new int[]{-1, 0, 3, 5, 9, 12}, 2);
    }
}
