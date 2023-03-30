package com.study.LeetCode.algorithm06Sort;

import java.util.Arrays;

/**
 * 归并排序*
 */
public class Mar30Sort06Merge {

    public static void mergeSort(int[] array) {
        if (array == null || array.length == 1)
            return;
        array = merge(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] merge(int[] array, int leftBound, int rightBound) {
        //只有两个元素,进行排序返回
        if (rightBound - leftBound <= 1) {
            //只有一个元素
            if (rightBound - leftBound == 0)
                return Arrays.copyOfRange(array, leftBound, rightBound + 1);
            if (array[leftBound] > array[rightBound]) {
                int temp = array[leftBound];
                array[leftBound] = array[rightBound];
                array[rightBound] = temp;
            }
            return Arrays.copyOfRange(array, leftBound, rightBound + 1);
        }
        //拆分
        int mid = (leftBound + rightBound) / 2;
        int[] array1 = merge(array, leftBound, mid);
        int[] array2 = merge(array, mid + 1, rightBound);
        //比较两边数组元素，放入新数组返回
        int[] newArray = new int[rightBound - leftBound + 1];
        int pos = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < array1.length || rightIndex < array2.length) {
            if (leftIndex >= array1.length)
                newArray[pos++] = array2[rightIndex++];
            else if (rightIndex >= array2.length)
                newArray[pos++] = array1[leftIndex++];
            else if (array1[leftIndex] < array2[rightIndex])
                newArray[pos++] = array1[leftIndex++];
            else if (array1[leftIndex] >= array2[rightIndex])
                newArray[pos++] = array2[rightIndex++];
        }
        return newArray;
    }

    public static void main(String[] args) {
        mergeSort(new int[]{1, 88, -5, 2, 8, 98, 1, -8, 5, -10, 4});
    }
}
