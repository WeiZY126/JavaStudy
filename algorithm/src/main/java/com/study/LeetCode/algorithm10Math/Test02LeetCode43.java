package com.study.LeetCode.algorithm10Math;

/**
 * 字符串相乘
 */
public class Test02LeetCode43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int int1 = num1.charAt(i) - 48;
                int int2 = num2.charAt(j) - 48;
                arr[i + j + 1] += int1 * int2;
            }
        }

        for (int i = arr.length - 1; i >= 1; i--) {
            //计算个位
            int i1 = arr[i];
            arr[i] = i1 % 10;
            arr[i - 1] += i1 / 10;
        }

        //没有前导0，所以只有可能第一位为0
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(arr[0] == 0 ? "" : arr[0]);

        for (int i = 1; i < arr.length; i++) {
            stringBuffer.append(arr[i]);
        }
        return stringBuffer.toString();
    }
}
