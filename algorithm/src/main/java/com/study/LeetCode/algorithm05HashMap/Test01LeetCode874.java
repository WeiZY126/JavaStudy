package com.study.LeetCode.algorithm05HashMap;

import java.util.HashSet;

/**
 * 模拟行走机器人
 */
public class Test01LeetCode874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] robotPos = new int[][]{{0, 0}};

        //如果dire%4=0，向北走，=1向东走，=2向南走，=3向西走
        int[][] direArr = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dire = 0;
        int maxRes = 0;
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            hashSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        for (int command : commands) {
            if (command == -1) {
                //向右转
                dire++;
            } else if (command == -2) {
                //向左转
                //注意，如果向北时，向左，方向会变成向西
                dire = dire == 0 ? 3 : dire - 1;
            } else {
                //取余，获取方向
                int d = dire % 4;
                for (int i = 0; i < command; i++) {
                    String nextPos = (robotPos[0][0] + direArr[d][0]) + "," + (robotPos[0][1] + direArr[d][1]);
                    //如果下一步不包含障碍物，则行动
                    if (!hashSet.contains(nextPos)) {
                        robotPos[0][0] += direArr[d][0];
                        robotPos[0][1] += direArr[d][1];
                    } else {
                        //否则停止，跳出当前循环
                        break;
                    }
                }
                //判断当前距离是否大于最大值
                maxRes = Math.max(maxRes, robotPos[0][0] * robotPos[0][0] + robotPos[0][1] * robotPos[0][1]);

            }
        }
        return maxRes;
    }
}
