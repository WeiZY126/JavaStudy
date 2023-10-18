package com.study.LeetCode.algorithm12Greedy;

public class Test06LeetCode134 {
    public static void main(String[] args) {
        new Test06LeetCode134().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        //遍历数组，如果总油耗大于总加油数，说明无法完成，直接返回，否则，则说明一定存在一条路线
        int retain = 0;
        for (int i = 0; i < gas.length; i++) {
            retain = retain + gas[i] - cost[i];
        }
        if (retain < 0)
            return -1;

        //此时，总加油数大于等于油耗，一定存在一条路线
        //此时使用跳跃遍历
        int i = 0;
        int index = i;
        retain = 0;
        while (i < gas.length) {
            retain = retain + gas[i] - cost[i];
            if (retain >= 0) {
                i++;
            } else {
                //置空汽油
                retain = 0;
                index = i + 1;
                i++;
            }
        }
        return index;
    }
}
