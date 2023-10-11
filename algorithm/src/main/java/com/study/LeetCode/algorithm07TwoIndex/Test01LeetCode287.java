package com.study.LeetCode.algorithm07TwoIndex;

/**
 * 寻找重复数
 */
public class Test01LeetCode287 {
    public int findDuplicate(int[] nums) {
        int fastIndex = 0;
        int slowIndex = 0;

        //找出是否带环
        do {
            fastIndex = nums[nums[fastIndex]];
            slowIndex = nums[slowIndex];
        } while (fastIndex != slowIndex);

        slowIndex = 0;
        while (fastIndex!=slowIndex){
            slowIndex = nums[slowIndex];
            fastIndex = nums[fastIndex];
        }
        return nums[fastIndex];
    }
}
