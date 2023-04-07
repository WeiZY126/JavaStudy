package com.study.LeetCode.algorithm06Sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 桶排序*
 */
public class Mar32Sort09Bucket {
    static int pos = 0;

    public static void bucketSort(int[] array, int bucketCap) {
        if (array == null || array.length <= 1)
            return;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //找到最大值和最小值
        for (int i : array) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        //获得桶数量
        int bucketNum = (max - min) / bucketCap + 1;
        //构建桶
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>(bucketCap));
        }

        //将数据放入桶
        for (int i : array) {
            bucketArr.get((i - min) / bucketCap).add(i);
        }

        for (ArrayList<Integer> integers : bucketArr) {
            integers.sort(null);
            for (Integer integer : integers) {
                array[pos++] = integer;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 88, 5, 2, 8, 98, 1, 8, 5, 10, 4};
        bucketSort(ints, 3);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
