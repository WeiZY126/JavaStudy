package com.study.LeetCode.algorithm06Sort;

/**
 * 快速排序*
 */
public class Mar29Sort04Quick {
    public static void main(String[] args) {
        quickSort(new int[]{-5, 2, 8, 98, 1, -8, 5, 4});
    }

    public static void quickSort(int[] array) {
        if (array == null)
            return;
        quickSort(array, 0, array.length);
        for (int i : array) {
            System.out.println(i);
        }

    }

    public static void quickSort(int[] array, int leftBound, int rightBound) {
        if (leftBound >= rightBound)
            return;
        //取最右边元素为基准值
        //分区指示器
        int partIndex = leftBound - 1;
        for (int i = leftBound; i < rightBound; i++) {
            /*
            当前数字小于等于基准值时
            分割指示器向后移一位
            如果当前下标大于分割指示器，交换两个下标的值
            */
            if (array[rightBound - 1] >= array[i]) {
                partIndex++;
                if (i > partIndex) {
                    int temp = array[i];
                    array[i] = array[partIndex];
                    array[partIndex] = temp;
                }
            }
        }
        //此时，分区指示器为分割位置,递归左右两边分区
        quickSort(array, 0, partIndex - 1);
        quickSort(array, partIndex + 1, rightBound);
    }
}
