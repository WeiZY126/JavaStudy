package com.study.LeetCode.algorithm14DynamicProgramming;

/**
 * 优化游戏背包 一维数组*
 */
public class Apr13GameBackpack3 {
    public static void main(String[] args) {
        Prop[] props = {
                new Prop("tam", 9, 1),
                new Prop("gg", 9, 4),
                new Prop("yhy", 9, 2),
                new Prop("bdl", 7, 1),
                new Prop("tt", 6, 1),
                new Prop("ymy", 8, 2),
                new Prop("gwf", 5, 1)
        };
        outBag(props, 6);

    }

    public static void outBag(Prop[] props, int bagSize) {
        int[] resArray = new int[bagSize + 1];
        resArray[0] = 0;
        for (Prop prop : props) {
            for (int i = bagSize; i > 0; i--) {
                if (prop.cost > i) {
                    resArray[i] = resArray[i];
                } else {
                    resArray[i] = Math.max(resArray[i], prop.value + resArray[i - prop.cost]);
                }
            }
        }
        System.out.println(resArray[bagSize]);
    }
}

