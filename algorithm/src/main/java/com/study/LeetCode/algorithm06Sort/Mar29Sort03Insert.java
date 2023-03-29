package com.study.LeetCode.algorithm06Sort;

/**
 * 插入排序*
 */
public class Mar29Sort03Insert {
    public static void insertSort(int[] array) {
        if (array==null)
            return;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int value = array[i];
                int tempIndex = i;
                //将比较元素后移一位
                while (tempIndex > 0 && value < array[tempIndex - 1]) {
                    array[tempIndex] = array[--tempIndex];
                }
                array[tempIndex] = value;
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        insertSort(new int[]{-5, 2, 8, 98, 1, -8, 5, 4});
    }

}
