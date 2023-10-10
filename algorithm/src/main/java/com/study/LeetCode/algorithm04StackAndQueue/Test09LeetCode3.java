package com.study.LeetCode.algorithm04StackAndQueue;

/**
 * 无重复字符的最长子串
 */
public class Test09LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1)
            return 0;
        int[] arr = new int[128];
        int count = 0;
        int longestLength = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            arr[c]++;
            //如果大于一，说明有重复字符
            if (arr[c] > 1) {
                count++;
            }
            while (count != 0) {
                //移动左窗口，直到count变为0
                char c1 = s.charAt(left);
                if (arr[c1] > 1)
                    count--;
                arr[c1]--;
                left++;
            }
            right++;
            longestLength = Math.max(right - left, longestLength);
        }
        return longestLength;
    }
}
