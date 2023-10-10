package com.study.LeetCode.algorithm04StackAndQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 */
public class Test11LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (p.length() == 0)
            return resList;

        //创建数组，用与存储字符串标志
        int[] targetArr = new int[26];
        int[] windowArr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            targetArr[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;

        //双指针遍历（滑动窗口）
        while (right < s.length()) {
            char c = s.charAt(right);
            windowArr[c - 'a']++;

            boolean isSame = true;
            for (int i = 0; i < targetArr.length; i++) {
                if (targetArr[i] != windowArr[i]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                resList.add(left);
            }

            //当窗口大小达到子串长度时
            if (right-left+1==p.length()) {
                //左指针向右移动一位
                char c1 = s.charAt(left++);
                windowArr[c1 - 'a']--;
            }
            //右指针向右移一位
            right++;
        }
        return resList;
    }
}
