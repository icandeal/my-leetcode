package com.ycf.q746;

/**
 * @author yuchunfan
 * @since 2024/3/8
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] cost = new int[] {1,100,1,1,1,100,1,1,100,1};
    System.out.println(solution.minCostClimbingStairs(cost));

    int[] cost1 = new int[] {10,15,20};
    System.out.println(solution.minCostClimbingStairs(cost1));
  }

  public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];
    dp[0] = 0;
    dp[1] = 0;
    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
    }
    return dp[cost.length];
  }
}