package com.study.LeetCode.algorithm05HashMap;

import java.util.*;

/**
 * 字母异位词分组
 */
public class Test05LsstCode49 {
    public static void main(String[] args) {
        System.out.println(new Test05LsstCode49().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat","ac","bd","aac","bbd","aacc","bbdd","acc","bdd"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            String afterStr = "";
            TreeMap<Character, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                treeMap.put(c, treeMap.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> characterIntegerEntry : treeMap.entrySet()) {
                afterStr += characterIntegerEntry.getKey().toString() + characterIntegerEntry.getValue();
            }
            List<String> list = hashMap.getOrDefault(afterStr, new ArrayList<>());
            list.add(str);
            hashMap.put(afterStr, list);
        }
        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
            lists.add(entry.getValue());
        }
        return lists;
    }
}
