package com.study.LeetCode.algorithm09String;

import java.util.Stack;

/**
 * 有效的括号*
 */
public class Apr11LeetCode20 {
    //栈
    public static boolean leetCode20(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (stack.empty() || stack.pop() != c)
                        return false;
            }
        }
        return stack.empty();
    }
}
