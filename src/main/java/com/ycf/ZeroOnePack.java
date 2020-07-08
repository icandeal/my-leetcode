package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/7.
 *
 * 0/1 背包问题
 *
 * 有个容量为 C 的背包，装取价值不等的钻石，
 * 每个钻石的容量与价值各异，每个钻石只有唯一一个
 * 求怎样装取最大价值的钻石
 */
public class ZeroOnePack {

    @Test
    public void test() {
        int[] vs = {2,2,5,3,7}; // 价值
        int[] ws = {1,2,3,5,5}; // 容量

        System.out.println(zeroOnePack(vs, ws, 10));
        System.out.println(dps(vs, ws, 10));
        System.out.println(dpsPlus(vs, ws, 10));
    }

    public int zeroOnePack(int[] vs, int[] ws, int capacity) {
        return zeroOnePack(vs, ws, capacity, vs.length - 1);
    }

    public int zeroOnePack(int[] vs, int[] ws, int capacity, int i) {
        if (i < 0){
            return 0;
        }

        if (capacity < ws[i]) {             // 容量装不下
            return zeroOnePack(vs, ws, capacity, i - 1);
        } else {                            // 容量可以装下
            return Math.max(zeroOnePack(vs, ws, capacity, i - 1), zeroOnePack(vs, ws, capacity - ws[i], i - 1) + vs[i]);
        }
    }

    public int dps(int[] vs, int[] ws, int capacity) {
        int[][] dp = new int[vs.length][capacity + 1];

        for (int i = 0; i <= capacity; i++) {   // 初始化，第一个宝石最优解
            if (ws[0] <= i)
                dp[0][i] = vs[0];
            else
                dp[0][i] = 0;
        }

        for (int i = 1; i < vs.length; i++) {   // 从第二个宝石开始，比较上颗宝石最优解
            for (int j = 0; j <= capacity; j++) {   // 从容量为0开始生成解表
                if (j < ws[i]) {                    // 放不下第i颗宝石，则使用之前的最优解
                    dp[i][j] = dp[i - 1][j];
                } else {                            // 可以放下第i颗宝石，则比较之前的最优解（不放入i） 与 放入i后加上之前容量为（j-当前宝石容量）的最优解
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - ws[i]] + vs[i]);
                }
            }
        }
        return dp[ws.length - 1][capacity];
    }

    public int dpsPlus(int[] vs, int[] ws, int capacity) {
        int[] dp = new int[capacity + 1];   // 因为每次宝石的规划只依托于上一颗宝石最优解，所以改为1维数组

        for (int i = 0; i <= capacity; i++) {   // 初始化
            if (i < ws[0])
                dp[i] = 0;
            else
                dp[i] = vs[0];
        }

        for (int i = 1; i < vs.length; i++) {
            for (int j = capacity; j >= ws[i]; j--) {   // 因为当容量小于当前宝石容量时，最优解不变, 倒排是为了改变不影响之后结果
                dp[j] = Math.max(dp[j], dp[j - ws[i]] + vs[i]);
            }
        }
        return dp[capacity];
    }
}
