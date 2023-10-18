package com.study.LeetCode.algorithm13Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */
public class Test08LeetCode39 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, 0, 0, new ArrayList<>());
        return lists;
    }

    public void combinationSum(int[] candidates, int target, int index, int sum, ArrayList<Integer> list) {
        if (sum == target) {
            lists.add(new ArrayList<>(list));
            return;
        }
        while (index < candidates.length) {
            int num = candidates[index];
            //如果当前值大于target，直接进入下一轮
            if (num > target) {
                index++;
                continue;
            }
            if (sum + num <= target) {
                sum += num;
                list.add(num);
                combinationSum(candidates, target, index, sum, list);
                //计算完成，恢复状态
                list.remove((Integer) num);
                sum -= num;
            }
            index++;
        }
    }
}
