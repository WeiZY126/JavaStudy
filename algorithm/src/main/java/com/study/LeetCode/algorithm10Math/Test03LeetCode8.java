package com.study.LeetCode.algorithm10Math;

/**
 * 字符串转换整数 (atoi)
 */
public class Test03LeetCode8 {
    public int myAtoi(String s) {
        int res = 0;
        //默认为正数
        boolean nag = false;

        //去除空格
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length())
            return res;
        //如果为负数，标志位设为负数
        if (s.charAt(index) == '-') {
            nag = true;
            index++;
        } else if (s.charAt(index) == '+') {
            //如果为正数，索引加一
            index++;
        }

        //开始判断数字
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            int i = s.charAt(index) - 48;
            if (res >= 214748364) {
                if (nag) {
                    if (i < 8 && res == 214748364) {
                    } else {
                        return -2147483648;
                    }
                } else {
                    if (i < 7 && res == 214748364) {
                    } else {
                        return 2147483647;
                    }
                }
            }
            res = res * 10;
            res += i;
            index++;
        }
        res /= 10;
        if (nag)
            return res * -1;
        return res;
    }
}
