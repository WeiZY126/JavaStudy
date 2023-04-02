package com.study.LeetCode.algorithm06Sort;

public class Mar31Sort07heap {
    public static void heapSort(int[] array) {
        if (array == null || array.length <= 1)
            return;
        for (int i = array.length - 1; i >= 0; i--) {
            //最后一个非叶子结点
            int pos = i / 2 - 1;
            //构建最大堆
            for (int j = pos; j >= 0; j--) {
                if ((2 * j + 1) < array.length && array[2 * j + 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[2 * j + 1];
                    array[2 * j + 1] = temp;
                }
                if ((2 * (j + 1)) < array.length && array[2 * (j + 1)] > array[j]) {
                    int temp = array[j];
                    array[j] = array[2 * (j + 1)];
                    array[2 * (j + 1)] = temp;
                }
            }
            //交换根节点与最后一个叶子结点
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        heapSort(new int[]{1, 88, -5, 2, 8, 98, 1, -8, 5, -10, 4});
    }
}


