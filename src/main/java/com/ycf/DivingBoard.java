package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/8.
 *
 * LeetCode 面试题 16.11. 跳水板
 * 难度 简单
 */
public class DivingBoard {

    @Test
    public void test() {
        for (int i: divingBoard(1,2, 3))
            System.out.print(i + " ");
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0)
            return new int[0];
        if (shorter == longer)
            return new int[]{shorter * k};
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = longer * i + shorter * (k - i);
        }

        return res;
    }
}
