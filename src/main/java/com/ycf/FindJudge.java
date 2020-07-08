package com.ycf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuchunfan on 2020/6/29.
 *
 * LeetCode 997. 找到小镇的法官
 * 难度 简单
 */
public class FindJudge {

    @Test
    public void test() {
        System.out.println(findJudge(1, new int[0][0]));
    }

    public int findJudge(int N, int[][] trust) {
        int rtn = -1;
        if (N != 1 && (trust.length < 1 || (trust.length == 1 && trust[0].length == 0)))
            return rtn;
        else if (N == 1) {
            return 1;
        }
        int[] v = new int[N];
        int[] t = new int[N];
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < trust.length; i++) {
            int v1 = trust[i][0] - 1;
            int t1 = trust[i][1] - 1;
            v[v1] ++;
            t[t1] ++;
            if (t[t1] == N - 1) {
                max.add(t1);
            }
        }
        for (int i: max) {
            if (v[i] == 0) {
                if (rtn != -1) {
                    rtn = -1;
                    break;
                }
                rtn = i + 1;
            }
        }
        return rtn;
    }
}
