package com.study.LeetCode.algorithm10DynamicProgramming;

/**
 * 用rand7()实现rand10()*
 */
public class Apr19LeetCode470 {
    public int LeetCode470() {
        int num = 40;
        while (num >= 40)
            num = (rand7() - 1) * 7 + (rand7() - 1);
        return num % 10 + 1;
    }

    public int rand7() {
        return 0;
    }
}
