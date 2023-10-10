package com.study.LeetCode.algorithm05HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有的子串
 */
public class Test02LeetCode30 {
    public static void main(String[] args) {
        System.out.println(new Test02LeetCode30().findSubstring("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab",
                new String[]{"ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "ab", "bc"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> resList = new ArrayList<>();
        int strArrayLength = words.length;
        int strLength = words[0].length();
        //子串总长度
        int finaLength = strArrayLength * strLength;
        //如果字符串长度小于finaLength，则说明不存在子串
        if (s.length() < finaLength)
            return resList;

        //创建目标Map与窗口Map
        HashMap<String, Integer> targetMap = new HashMap<>();

        for (String word : words) {
            Integer num = targetMap.get(word);
            targetMap.put(word, num == null ? 1 : num + 1);
        }

        int index = 0;
        while (index < strLength) {
            int count = 0;
            HashMap<String, Integer> windowMap = new HashMap<>();
            for (int r = index + strLength, l = index; r <= s.length(); r += strLength) {

                String substring = s.substring(r - strLength, r);
                Integer tarNum = targetMap.get(substring);
                if (tarNum == null) {
                    l = r;
                }

                Integer winNum = windowMap.get(substring);
                //移动左指针
                while (l < r && winNum!=null && winNum.intValue() == tarNum.intValue()) {
                    String s1 = s.substring(l, l + strLength);
                    Integer winNum2 = windowMap.get(s1);
                    windowMap.put(s1, winNum2 - 1);
                    l += strLength;
                    winNum = windowMap.get(substring);
                    count--;
                }

                if (l == r) {
                    count = 0;
                    windowMap.clear();
                    continue;
                }

                //如果winNum<tarNum
                windowMap.put(substring, winNum == null ? 1 : winNum + 1);
                count++;
                if (count == strArrayLength)
                    resList.add(l);
            }
            index++;
        }
        return resList;
    }
}
