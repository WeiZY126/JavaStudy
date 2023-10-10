package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.Stack;

/**
 * 最大矩形
 */
public class Test06LeetCode85 {
    public static void main(String[] args) {
        new Test06LeetCode85().maximalRectangle(new char[][]{{'0'}});
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxValue = 0;

        //转换为一维柱状图
        int[] arr = new int[cols + 2];
        //补0，便于判断边界
        arr[0] = 0;
        arr[arr.length - 1] = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0')
                    arr[j + 1] = 0;
                else
                    arr[j + 1] = arr[j + 1] + 1;
            }
            //计算每一轮最大的矩形
            Stack<Integer> stack = new Stack<Integer>();

            for (int k = 0; k < arr.length; k++) {
                while (stack != null && arr[k] < arr[stack.peek()]) {
                    //取出栈顶元素
                    Integer pop = stack.pop();
                    //取出的栈顶元素左边界为当前栈顶元素
                    int left = stack.peek();
                    //有边界为当前遍历的位置
                    int right = k;
                    int length = right - left - 1;
                    int height = arr[pop];

                    maxValue = Math.max(length * height, maxValue);
                }
                //取到栈顶元素比当前元素小，把当前元素push入栈
                stack.push(k);
            }
        }

        return maxValue;
    }
}
