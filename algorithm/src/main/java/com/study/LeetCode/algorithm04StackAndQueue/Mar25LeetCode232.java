package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.Stack;

/**
 * 用栈实现队列*
 */
public class Mar25LeetCode232 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public Mar25LeetCode232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (!outStack.empty()) {
            return outStack.pop();
        } else {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
    }

    public int peek() {
        if (!outStack.empty()) {
            return outStack.peek();
        } else {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }
    }

    public boolean empty() {
        return inStack.empty() & outStack.empty();
    }
}
