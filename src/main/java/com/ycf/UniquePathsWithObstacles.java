package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/6.
 *
 * LeetCode 63. 不同路径 II
 * 难度 中等
 */
public class UniquePathsWithObstacles {

    @Test
    public void test() {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return move(obstacleGrid, 0, 0);
    }

    public int move(int[][] obstacleGrid, int x, int y) {
        if (obstacleGrid[x][y] == 1)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int res = 0;

        if (x == m - 1 && y == n - 1) {
            res = 1;
        }
        if (x < m - 1)
            res += move(obstacleGrid, x + 1, y);
        if (y < n - 1)
            res += move(obstacleGrid, x, y + 1);


        return res;
    }
}
