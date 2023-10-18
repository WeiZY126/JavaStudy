package com.study.LeetCode.algorithm12Greedy;

/**
 * 跳跃游戏
 */
public class Test06LeetCode55 {
    public static void main(String[] args) {
        new Test06LeetCode55().canJump(new int[]{3, 2, 1, 0, 4});
    }

    public boolean canJump(int[] nums) {

        //只需要维护一个最远距离
        int maxIndexx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //当前下标需要小于或等于可以达到的最远位置
            if (i <= maxIndexx) {
                if (num + i > maxIndexx) {
                    maxIndexx = num + i;
                }
            }
            if (maxIndexx >= nums.length - 1)
                return true;
        }
        return false;
    }
}
