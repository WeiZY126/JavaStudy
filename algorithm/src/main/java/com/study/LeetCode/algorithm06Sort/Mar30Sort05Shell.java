package com.study.LeetCode.algorithm06Sort;

/**
 * 希尔排序*
 */
public class Mar30Sort05Shell {
    public static void shellSort(int[] array) {
        int increment = array.length;
        while (increment / 2 >= 1) {
            increment /= 2;
            for (int j = increment; j < array.length; j++) {
                if (array[j] < array[j - increment]) {
                    int k = j;
                    int value = array[j];
                    while (k - increment >= 0 && array[k - increment] > value) {
                        array[k] = array[k - increment];
                        k -= increment;
                    }
                    array[k] = value;
                }
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        shellSort(new int[]{88, -5, 2, 8, 98, 1, -8, 5, -10, 4});
    }
}
