package com.study.LeetCode.algorithm07TwoIndex;

import java.util.*;

public class Test03LeetCode18 {
    public static void main(String[] args) {
        new Test03LeetCode18().fourSum(new int[]{-3,-1,0,2,4,5}, 2);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int a = 0;
        while (a <= nums.length - 4) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                a++;
                continue;
            }
            if ((long)nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] == target) {
                lists.add(Arrays.asList(new Integer[]{(nums[a]), nums[a + 1], nums[a + 2], nums[a + 3]}));
                a++;
                continue;
            }
            int b = a + 1;
            while (b <= nums.length - 3) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    b++;
                    continue;
                }
                int left = b + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (left > b + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    while (right > left && (long)nums[a] + nums[b] + nums[left] + nums[right] > target)
                        right--;
                    while (right > left && (long)nums[a] + nums[b] + nums[left] + nums[right] < target)
                        left++;
                    if (right > left && (long)nums[a] + nums[b] + nums[left] + nums[right] == target) {
                        lists.add(Arrays.asList(new Integer[]{nums[a], nums[b], nums[left++], nums[right--]}));
                    }
                }
                b++;
            }
            a++;
        }
        return lists;
    }
}
