package com.study.LeetCode.algorithm06Sort;

/**
 * 冒泡排序*
 */
public class Mar29Sort01Bubble {
    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        int len = array.length - 1;
        while (len >= 0) {
            for (int i = 0; i < len; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            len--;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{-5, 2, 8, 98, 1, 5, 4});
    }
}
