package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/8.
 *
 * 斐波那契数列
 * 动态规划
 */
public class FibonacciSeq {

    @Test
    public void test() {
        fibonacciSeq(15);
    }

    public void fibonacciSeq(int size) {
        int[] seq = new int[size];
        if (size > 0)
            seq[0] = 1;
        if (size > 1)
            seq[1] = 1;

        for (int i = 2; i < size; i++) {
            seq[i] = seq[i - 1] + seq[i - 2];
        }

        for (int num: seq) {
            System.out.print(num + " ");
        }
    }
}
