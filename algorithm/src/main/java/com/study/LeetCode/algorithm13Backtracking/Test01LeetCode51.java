package com.study.LeetCode.algorithm13Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 */
public class Test01LeetCode51 {
    public static void main(String[] args) {
        System.out.println(new Test01LeetCode51().solveNQueens(4));
    }

    List<List<String>> lists = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] attack = new int[n][n];

        int[][] queueArray = new int[n][n];

        //初始坐标
        solveNQueens(n, 0, 0, queueArray, attack);
        return lists;
    }

    public void solveNQueens(int n, int x, int y, int[][] queueArray, int[][] attack) {
        //进入第N+1层，说明数组已经放入了N个函数，递归结束，记录结果值
        if (x == n) {
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String res = "";
                for (int j = 0; j < n; j++) {
                    if (queueArray[i][j] == 0) {
                        res += ".";
                    } else {
                        res += "Q";
                    }
                }
                strings.add(res);
            }
            lists.add(strings);
            return;
        }
        while (y < n) {
            //复制数组，以用于回退;
            int[][] tempAttack = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tempAttack[i][j] = attack[i][j];
                }
            }
            if (attack[x][y] == 0) {
                //更新皇后数组
                queueArray[x][y] = 1;
                //更新攻击数组
                updateAttack(x, y, attack);
                //进入下一层
                solveNQueens(n, x + 1, 0, queueArray, attack);
                //下一层返回后，回退两个数组状态
                queueArray[x][y] = 0;
                attack = tempAttack;
            }
            y++;
        }
    }

    /**
     * 更新attack
     */
    public void updateAttack(int x, int y, int[][] attack) {
        //dx,dy分别为第一圈时，皇后的八个方向攻击范围，如{dx[0],dy[0]}->{x-1,y-1}
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        int length = attack.length;
        for (int i = 0; i < 8; i++) {
            //8个方向
            for (int i1 = 0; i1 < length; i1++) {
                //第i1圈
                //行坐标
                int attackX = x + i1 * dx[i];
                //列坐标
                int attackY = y + i1 * dy[i];
                if (attackX >= 0 && attackX < length && attackY >= 0 && attackY < length) {
                    attack[attackX][attackY] = 1;
                }
            }
        }
    }
}
