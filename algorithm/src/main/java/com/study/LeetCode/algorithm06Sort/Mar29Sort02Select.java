package com.study.LeetCode.algorithm06Sort;

/**
 * 选择排序*
 */
public class Mar29Sort02Select {
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int maxVal = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int j = i; j < array.length; j++) {
                if (array[j] > maxVal) {
                    maxVal = array[j];
                    maxIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        selectSort(new int[]{-5, 2, 8, 98, 1, -8, 5, 4});
    }
}
