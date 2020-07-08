package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/6/30.
 * 
 * LeetCode 378. 有序矩阵中第K小的元素
 * 难度 中等
 */
public class KthSmallest {

    @Test
    public void test() {
        int[][] matrix = new int[][]{
            { 1,  5,  9},
            {10, 11, 13},
            {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 3));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int cnt = 0, len = matrix.length, idx = 0, rtn = Integer.MAX_VALUE;
        for (int i = 0; i < 2 * len - 1; i ++ ) {
            if (i < len) {
                cnt += i + 1;
            }
            else  {
                cnt += 2 * len - i - 1;
            }
            if (cnt > k) {
                idx = i - 1;
                break;
            }
        }
        int j;
        for (int i = 0; i < len; i++) {
            if (idx >= len ) {
                j = 2 * len - idx - i;
            } else {
                j = idx - i;
            }
            if (j < len && j >= 0 && rtn > matrix[i][j])
                rtn = matrix[i][j];
        }
        return rtn;
    }
}
