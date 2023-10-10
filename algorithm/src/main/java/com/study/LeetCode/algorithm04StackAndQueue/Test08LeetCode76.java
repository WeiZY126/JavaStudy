package com.study.LeetCode.algorithm04StackAndQueue;

/**
 * 最小覆盖子串
 */
public class Test08LeetCode76 {
    public static void main(String[] args) {
        new Test08LeetCode76().minWindow("ADOBECODEBANC","ABC");
    }
    public String minWindow(String s, String t) {
        if (t == null || t.length() <= 0)
            return "";
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        //ASCII 'z'=122
        int[] targetArr = new int[128];

        for (char tChar : tChars) {
            targetArr[tChar]++;
        }

        int count = t.length();
        int windowLength = s.length() + 1;
        int start = 0;
        int left = 0;
        int right = 0;
        while (right < sChars.length) {
            if (targetArr[sChars[right]] > 0) {
                //需要搜索的次数减少了
                count--;
            }
            targetArr[sChars[right]]--;
            while (count == 0) {
                if (right - left + 1 < windowLength) {
                    //更新最小窗口长度
                    windowLength = right - left + 1;
                    //更新滑动窗口起始位置
                    start = left;
                }
                //数组不可能存在大于0的情况，只可能等于0(需要字符)和小于0(无效字符)
                if (targetArr[sChars[left]] == 0) {
                    //当碰到需要的字符时
                    count++;
                }
                targetArr[sChars[left]]++;
                left++;
            }
            right++;
        }
        return windowLength == s.length() + 1 ? "" : s.substring(start, start + windowLength);
    }
}
