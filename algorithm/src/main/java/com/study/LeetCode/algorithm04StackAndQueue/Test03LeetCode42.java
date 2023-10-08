package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.Stack;

/**
 * 接雨水
 */
public class Test03LeetCode42 {
    public static void main(String[] args) {
        new Test03LeetCode42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
    public int trap(int[] height) {
        if (height.length < 2)
            return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
                stack.push(i);
            } else {
                //取出栈顶元素
                Integer pop = stack.pop();
                //判断是否有左边界
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                //取出左边界
                Integer peek = stack.peek();
                //计算length,即下标差值
                int length = i - peek - 1;
                //计算高度，即Min(left,right)-mid
                int high = Math.min(height[peek], height[i]) - height[pop];
                //雨水面积为length*height
                res += length * high;
                //i减一，当前下标继续进入下一轮计算
                i--;
            }
        }
        return res;
    }
}
