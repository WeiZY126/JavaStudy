package com.study.LeetCode.algorithm13Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 子集
 */
public class Test02LeetCode78 {
    public static void main(String[] args) {
        new Test02LeetCode78().subsets(new int[]{1,2,3});
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        int length = nums.length;
        ArrayList<Integer> integers = new ArrayList<>();
        lists.add(new ArrayList<>());
        subsets(lists, integers, nums, 0, length);
        return lists;
    }

    public void subsets(List<List<Integer>> lists, List<Integer> list, int[] nums, int index, int length) {
        //当遍历到头时，退出
        if (index == length) {
            return;
        }
        for (int i = index; i < length; i++) {
            int num = nums[i];
            //选择当前值
            list.add(num);
            List<Integer> integers = new ArrayList<>();
            integers.addAll(list);
            lists.add(integers);
            subsets(lists, list, nums, i + 1, length);
            //退出循环，重置状态
            list.remove((Integer) num);
            //不选当前值，则直接跳过当前元素
        }
    }
}
