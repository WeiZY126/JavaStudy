package com.study.LeetCode.algorithm12Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class Test04LeetCode15 {
    public static void main(String[] args) {
        new Test04LeetCode15().threeSum(new int[]{-4, -1, -1, 0, 1, 2});

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int i = 0;
        while (i <= nums.length - 3) {
            //如果第一个数大于0，那么和一定大于0
            if (nums[i] > 0)
                break;
            //前一个数和当前数一样，会产生重复结果
            if (i > 0 && nums[i - 1] == nums[i]){
                i++;
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            i++;
        }
        return lists;
    }
}
