package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 字符串解码*
 */
public class Mar25LeetCode394 {
    /*官方解法*/
    public String LeetCode394Study(String s) {
        LinkedList<String> skt = new LinkedList<>();
        Integer pos = 0;
        while (pos < s.length()) {
            char c = s.charAt(pos);
            //处理数字
            if (Character.isDigit(c)) {
                StringBuffer ret = new StringBuffer();
                while (Character.isDigit(s.charAt(pos)))
                    ret.append(s.charAt(pos++));
                skt.addLast(ret.toString());
            } else if (Character.isLetter(c) || c == '[') {
                //处理普通字符，直接压栈
                skt.add(String.valueOf(s.charAt(pos++)));
            } else {
                //处理右括号
                ++pos;
                //用另一个list，将字符串出栈拼接
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(skt.peekLast())) {
                    sub.addLast(skt.removeLast());
                }
                //反转字符串
                Collections.reverse(sub);
                //左括号出栈
                skt.removeLast();
                //读取之前的数字
                int repTime = Integer.parseInt(skt.removeLast());
                String o = getString(sub);
                StringBuffer t = new StringBuffer();
                //构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                //构造好的字符串入栈
                skt.addLast(t.toString());
            }
        }
        return getString(skt);
    }

    public String getString(LinkedList<String> lks) {
        return null;

    }

    public String LeetCode394(String s) {
        Stack<String> stack = new Stack<String>();
        int pos = 0;
        String res = "";
        while (pos < s.length()) {
            char c = s.charAt(pos);
            String s1 = String.valueOf(c);
            //处理数字
            if (Character.isDigit(c)) {
                StringBuffer stringBuffer = new StringBuffer();
                while (pos < s.length() && Character.isDigit(s.charAt(pos)))
                    stringBuffer.append(s.charAt(pos++));
                stack.push(stringBuffer.toString());
            } else if (Character.isLetter(c) || c == '[') {
                stack.push(String.valueOf(s.charAt(pos++)));
            } else {
                //处理右括号
                StringBuffer stringBuffer = new StringBuffer();
                while (!stack.empty() && !"[".equals(stack.peek()))
                    stringBuffer.insert(0, stack.pop());
                //左括号出栈
                stack.pop();
                Integer num = 1;
                if (stack.peek() != null && Character.isDigit(stack.peek().charAt(0)))
                    num = Integer.valueOf(stack.pop());
                String tmp = stringBuffer.toString();
                for (Integer i = 0; i < num - 1; i++) {
                    stringBuffer.append(tmp);
                }
                stack.push(stringBuffer.toString());
                pos++;
            }
        }
        while (!stack.empty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Mar25LeetCode394().LeetCode394("100[leetcode]"));
    }
}
