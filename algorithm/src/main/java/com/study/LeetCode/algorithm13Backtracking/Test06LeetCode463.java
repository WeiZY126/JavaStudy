package com.study.LeetCode.algorithm13Backtracking;

/**
 * 岛屿的周长
 */
public class Test06LeetCode463 {
    int num = 0;

    public int islandPerimeter(int[][] grid) {
        int[][] ints = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islandPerimeter(i, j, grid, ints);
                    return num;
                }
            }
        }
        return num;
    }

    public void islandPerimeter(int x, int y, int[][] grid, int[][] mark) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == 0) {
            num++;
            return;
        }
        if (mark[x][y] == 1)
            return;
        //标记
        mark[x][y] = 1;
        //遍历上边
        islandPerimeter(x - 1, y, grid, mark);
        //遍历左边
        islandPerimeter(x, y - 1, grid, mark);
        //遍历下边
        islandPerimeter(x + 1, y, grid, mark);
        //遍历右边
        islandPerimeter(x, y + 1, grid, mark);
    }
}
