package com.study.LeetCode.algorithm13Backtracking;

/**
 * 岛屿数量
 */
public class Test05LeetCode200 {
    public static void main(String[] args) {

        new Test05LeetCode200().numIslands(new char[][]{{'0', '0', '0', '0', '1'}});
    }

    int num = 0;

    public int numIslands(char[][] grid) {
        int[][] markArr = new int[grid.length][grid[0].length];

        numIslands(0, 0, 0, markArr, grid);
        return num;
    }

    public void numIslands(int level, int x, int y, int[][] markArr, char[][] grid) {
        //终止条件，当右侧和下侧都为水
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length
                || markArr[x][y] == 1 || (level != 0 && grid[x][y] == '0')) {
            return;
        }
        for (int i = x; i < grid.length; i++) {
            for (int j = y; j < grid[i].length; j++) {
                if (markArr[i][j] == 1)
                    continue;
                if (grid[i][j] == '1') {
                    markArr[i][j] = 1;
                    //向上遍历
                    numIslands(level + 1, i - 1, j, markArr, grid);
                    //向左遍历
                    numIslands(level + 1, i, j - 1, markArr, grid);
                    //向下遍历
                    numIslands(level + 1, i + 1, j, markArr, grid);
                    //向右遍历
                    numIslands(level + 1, i, j + 1, markArr, grid);
                    //向右和向下都探索完成后，本岛探索结束
                    if (level == 0)
                        num++;
                    else
                        return;
                }
            }
        }
    }
}
