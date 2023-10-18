package com.study.LeetCode.algorithm13Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 */
public class Test04LeetCode77 {
    public static void main(String[] args) {
        System.out.println(new Test04LeetCode77().combine(4, 2));
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        combine(n, k, 1, new ArrayList<>());
        return lists;
    }

    public void combine(int n, int k, int index, List<Integer> list) {
        if (k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        while (index <= n - k + 1) {
            //加入当前元素
            list.add(index);
            //递归进入下一层，判断组合
            combine(n, k - 1, index + 1, list);
            //从下一层退出后，删除当前元素
            list.remove((Integer) index);
            index++;
        }
    }
}
