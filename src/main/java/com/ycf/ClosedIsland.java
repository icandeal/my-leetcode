package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/3.
 *
 * LeetCode 1254. 统计封闭岛屿的数目
 * 难度：中等
 */
public class ClosedIsland {

    @Test
    public static void test() {
        int[][] grid = new int[][]{
                {1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,1,0,1,0,1},
                {1,0,1,1,1,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1}
        };
        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int rtn = 0;
        int a = grid.length;
        int b = grid[0].length;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == 0 && lookAround(grid, i, j)) {
                    rtn++;
                }
            }
        }
        return rtn;
    }

    public static boolean lookAround (int[][] grid, int i, int j) {
        int a = grid.length;
        int b = grid[0].length;
        if (i <0 || j <0 || i >= a || j >= b) {
            return false;
        }
        if (grid[i][j] == 1)
            return true;
        grid[i][j] = 1;
        boolean l1 = lookAround(grid, i - 1, j);
        boolean l2 = lookAround(grid, i + 1, j);
        boolean l3 = lookAround(grid, i, j -1);
        boolean l4 = lookAround(grid, i, j + 1);
        if (l1 && l2 && l3 && l4)
            return true;
        return false;
    }
}
