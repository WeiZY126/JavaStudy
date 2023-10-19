package com.study.LeetCode.algorithm14DynamicProgramming;

/**
 * 优化游戏背包 反推+虚拟行列*
 */
public class Apr13GameBackpack2 {
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
        Integer[][] resArray = new Integer[props.length + 1][bagSize + 1];
        for (int i = 0; i < props.length + 1; i++) {
            for (int j = 0; j < bagSize + 1; j++) {
                //第0行第0列赋0值
                if (i == 0 || j == 0) {
                    resArray[i][j] = 0;
                } else {
                    Prop prop = props[i - 1];
                    if (prop.cost > j)
                        resArray[i][j] = resArray[i - 1][j];
                    else {
                        Integer lastValue = resArray[i - 1][j];
                        int thisValue = prop.value + resArray[i - 1][j - prop.cost];
                        resArray[i][j] = thisValue > lastValue ? thisValue : lastValue;
                    }
                }
            }
        }
        //反推
        int i = props.length;
        int j = bagSize;
        while (i > 0) {
            int propsIndex = i - 1;
            if (resArray[i][j] > resArray[i - 1][j]) {
                System.out.println(props[propsIndex]);
                i--;
                j -= props[propsIndex].cost;
            } else {
                i--;
            }
        }
        System.out.println(resArray[props.length][bagSize]);
    }
}

