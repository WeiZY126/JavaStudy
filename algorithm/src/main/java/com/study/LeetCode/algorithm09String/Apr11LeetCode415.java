package com.study.LeetCode.algorithm09String;

/**
 * 字符串相加*
 */
public class Apr11LeetCode415 {
    public String leetCode415(String num1, String num2) {
        boolean carry = false;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        String res = "";
        while (i >= 0 || j >= 0 || carry == true) {
            int a = i < 0 ? 0 : num1.charAt(i--) - '0';
            int b = j < 0 ? 0 : num2.charAt(j--) - '0';
            int num = a + b;
            if (carry)
                num += 1;
            stringBuffer.append(num % 10);
            if (num >= 10)
                carry = true;
            else
                carry = false;
        }
        return stringBuffer.reverse().toString();
    }
}
