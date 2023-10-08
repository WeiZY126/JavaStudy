package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.Stack;

/**
 * 逆波兰表达式
 */
public class Test04LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    stack.push(operatorNum(stack.pop(), stack.pop(), token));
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public int operatorNum(int pop1, int pop2, String operate) {
        switch (operate) {
            case "+":
                return pop2 + pop1;
            case "-":
                return pop2 - pop1;
            case "*":
                return pop2 * pop1;
            default:
                return pop2 / pop1;
        }
    }
}
