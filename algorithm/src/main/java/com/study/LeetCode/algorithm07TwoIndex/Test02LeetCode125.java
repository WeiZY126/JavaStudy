package com.study.LeetCode.algorithm07TwoIndex;

/**
 * 验证回文串
 */
public class Test02LeetCode125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int right = chars.length - 1;
        int left = 0;
        while (left < right) {
            while (left < chars.length && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (right >= 0 && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }

            if (right < 0 || left >= chars.length) {
                break;
            }

            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right]))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
