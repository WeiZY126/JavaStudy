package com.study.LeetCode.algorithm05HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度
 */
public class Test03LeetCode697 {
    public int findShortestSubArray(int[] nums) {
        int maxTime = 0;
        int shortNum = nums.length + 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer integer = map.get(i);
            integer = integer == null ? 0 : integer;
            map.put(i, integer++);
            if (integer > maxTime)
                maxTime = integer;
        }
        if (maxTime == 1)
            return 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxTime) {
                int firstIndex = -1;
                int lastIndex = -1;
                Integer key = entry.getKey();
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == key) {
                        if (firstIndex == -1)
                            firstIndex = i;
                        lastIndex = i;
                    }
                }
                shortNum = Math.min(shortNum, lastIndex - firstIndex + 1);
            }
        }
        return shortNum;
    }
}
