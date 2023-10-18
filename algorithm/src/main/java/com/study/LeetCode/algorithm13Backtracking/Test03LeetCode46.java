package com.study.LeetCode.algorithm13Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Test03LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permute(nums, nums.length, new ArrayList<>(), lists);
        return lists;

    }

    public void permute(int[] nums, int length, List<Integer> res, List<List<Integer>> lists) {
        if (res.size() < length) {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (!res.contains(num)) {
                    res.add(num);
                    permute(nums, length, res, lists);
                    //执行结束后，去除当前元素
                    res.remove((Integer) num);
                }
            }
        } else {
            List<Integer> integerList = new ArrayList<>();
            integerList.addAll(res);
            lists.add(integerList);
        }
    }
}
