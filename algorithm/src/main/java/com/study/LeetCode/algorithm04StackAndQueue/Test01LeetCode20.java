package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.Stack;

/**
 * 有效的括号
 */
public class Test01LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    characters.push(c);
                    break;
                case '}':
                    if (characters.isEmpty()||characters.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (characters.isEmpty()||characters.pop() != '[')
                        return false;
                    break;
                case ')':
                    if (characters.isEmpty()||characters.pop() != '(')
                        return false;
                    break;
            }
        }
        return characters.isEmpty();
    }
}
