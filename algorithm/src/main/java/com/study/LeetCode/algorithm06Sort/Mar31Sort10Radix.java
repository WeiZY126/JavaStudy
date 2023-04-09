package com.study.LeetCode.algorithm06Sort;

import java.util.ArrayList;

public class Mar31Sort10Radix {
    public static void RadixSort(int[] array) {
        if (array == null || array.length <= 1)
            return;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (i > max)
                max = i;
        }
        //计算位数
        int digit = 0;
        for (int i = max; i > 0; i /= 10) {
            digit++;
        }
        //初始化桶
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 1; i <= digit; i++) {
            int digTmp = 1;
            for (int i1 = 1; i1 < i; i1++) {
                //获取当前位数
                digTmp *= 10;
            }
            for (int number : array) {
                int digitNum = number / digTmp % 10;
                //入桶
                bucket.get(digitNum).add(number);
            }
            //出桶
            int pos = 0;
            for (int i1 = 0; i1 < 10; i1++) {
                for (Integer integer : bucket.get(i1)) {
                    array[pos++] = integer;
                }
                bucket.get(i1).clear();
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        RadixSort(new int[]{-500, -80, 1, 88, 5, 2, 8, 98, 1, 8, 5, 10, 4});
    }
}
