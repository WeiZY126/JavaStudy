package com.study.LeetCode.algorithm06Sort;

/**
 * 计数排序*
 */
public class Mar31Sort08Count {
    public static void CountSort(int[] array) {
        if (array == null || array.length <= 1)
            return;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        int[] countArray = new int[max - min + 1];
        //初始化计数数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min] = countArray[array[i] - min] + 1;
        }

        int countIndex = 0;
        int resIndex = 0;
        while (countIndex < max - min + 1) {
            if (countArray[countIndex] != 0) {
                array[resIndex++] = countIndex + min;
                countArray[countIndex] = countArray[countIndex] - 1;
            } else
                countIndex++;
        }

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        CountSort(new int[]{1, 88, 5, 2, 8, 98, 1, 8, 5, 10, 4});
    }
}
