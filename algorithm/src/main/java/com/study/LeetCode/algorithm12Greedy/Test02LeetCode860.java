package com.study.LeetCode.algorithm12Greedy;

/**
 * 柠檬水找零
 */
public class Test02LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        int[] arr = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                arr[0]++;
            } else if (bill == 10) {
                if (arr[0] > 0) {
                    arr[0]--;
                    arr[1]++;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (arr[0] < 1) {
                    return false;
                }
                if (arr[1] > 0) {
                    arr[0]--;
                    arr[1]--;
                    arr[2]++;
                } else {
                    if (arr[0] < 3)
                        return false;
                    arr[0] -= 3;
                    arr[2]++;
                }
            }
        }
        return true;
    }
}
