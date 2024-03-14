package com.ycf.q122;

/**
 * @author yuchunfan
 * @since 2024/3/12
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[] {1,2,3,4,5};
    System.out.println(solution.maxProfit(nums));
  }

  public int maxProfitDp(int[] prices) {
    int[][] dp = new int[prices.length][2];

    dp[0][0] = 0;
    dp[0][1] = - prices[0];

    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[prices.length - 1][0];
  }

  public int maxProfit(int[] prices) {
    int sum = 0, min = prices[0], max = prices[0];
    for (int i = 1; i < prices.length; i++) {
      int price = prices[i];
      if (price < max && max > min) {
        sum += max - min;
        min = max = price;
        continue;
      }
      if (price < min) {
        min = price;
        max = price;
      }
      if (price > max) {
        max = price;
      }
    }
    return sum + (max > min ? max - min : 0);
  }
}
