package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.Stack;

/**
 * 最小栈
 */
public class Test02LeetCode155 {
    private Stack<Integer> commonStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public Test02LeetCode155() {

    }

    public void push(int val) {
        commonStack.push(val);
        //如果最小栈为空或当前值小于等于最小栈的栈顶，则插入最小栈
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = commonStack.pop();
        //如果最小栈不为空且取出的元素等于最小栈栈顶，则弹出
        if (!minStack.isEmpty() && minStack.peek() == val) {
            minStack.pop();
        }
    }

    public int top() {
        return commonStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
