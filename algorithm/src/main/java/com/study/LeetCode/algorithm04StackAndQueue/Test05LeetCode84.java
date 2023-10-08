package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.Stack;

public class Test05LeetCode84 {
    public static void main(String[] args) {
        new Test05LeetCode84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    public int largestRectangleArea(int[] heights) {
        //给左右边界各添加一个0，方便计算
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[heights.length + 1] = 0;
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;
        int maxNum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            //如果当前值小于栈顶，即栈顶确定了右边界
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                //获取高度
                Integer pop = stack.pop();
                Integer height = heights[pop];
                //单调递减栈，最新的栈顶元素即为左边界
                pop = stack.peek();
                //获取最大面积
                int length = i - pop;
                maxNum = Math.max((length * height), maxNum);
            }
            stack.push(i);
        }
        return maxNum;
    }
}
