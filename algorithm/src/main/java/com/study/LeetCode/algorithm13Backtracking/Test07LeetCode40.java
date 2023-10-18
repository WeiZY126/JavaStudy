package com.study.LeetCode.algorithm13Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和2
 */
public class Test07LeetCode40 {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //需要先排序，因为需要去除重复项
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, 0, new ArrayList<>());
        return lists;
    }

    public void combinationSum2(int[] candidates, int target, int index, int sum, ArrayList<Integer> list) {
        if (sum == target) {
            lists.add(new ArrayList<>(list));
            return;
        }
        while (index < candidates.length) {
            int num = candidates[index];
            //如果当前值大于target，直接返回,因为数组有序
            if (num > target) {
                return;
            }
            if (sum + num <= target) {
                sum += num;
                list.add(num);
                combinationSum2(candidates, target, index + 1, sum, list);
                //计算完成，恢复状态
                list.remove((Integer) num);
                sum -= num;
            } else {
                //剪枝，如果当前结果大于target，那后边所有和都大于target
                return;
            }
            while (index < candidates.length - 1 && candidates[index] == candidates[index + 1])
                index++;
            index++;
        }
    }
}
