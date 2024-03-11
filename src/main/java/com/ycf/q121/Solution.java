package com.ycf.q121;

/**
 * @author yuchunfan
 * @since 2024/3/8
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.maxProfit(new int[] {7,1,5,3,6,4}));
  }

  public int maxProfit(int[] prices) {
    int length = prices.length;
    int max = 0, min = prices[0];
    for (int i = 1; i < length; i++) {
      int price = prices[i];
      max = Math.max(max, price - min);
      min = Math.min(min, price);
    }

    return max;
  }
}
