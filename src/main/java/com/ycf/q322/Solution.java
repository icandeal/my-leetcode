package com.ycf.q322;

import com.ycf.LeetcodeUtils;

import java.util.Arrays;

/**
 * @author yuchunfan
 * @since 2024/3/29
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual(3, solution.coinChange(LeetcodeUtils.parseIntArray("[1, 2, 5]"), 11));
    LeetcodeUtils.testEqual(-1, solution.coinChange(LeetcodeUtils.parseIntArray("[2]"), 3));
    LeetcodeUtils.testEqual(0, solution.coinChange(LeetcodeUtils.parseIntArray("[1]"), 0));
    LeetcodeUtils.testEqual(20, solution.coinChange(LeetcodeUtils.parseIntArray("[186,419,83,408]"), 6249));
  }

  public int coinChange(int[] coins, int amount) {
    Arrays.sort(coins);
    return getMin(coins, coins.length - 1, amount);
  }

  public int getMin(int[] coins, int idx, int left) {
    if (idx < 0) {
      return -1;
    }
    int coin = coins[idx];
    int cnt = left / coin;
    for (int i = cnt; i >= 0; i--) {
      int sum = i * coin;
      if (sum == left) {
        return i;
      }
      int min = getMin(coins, idx - 1, left - sum);
      if (min != -1) {
        return i + min;
      }
    }
    return -1;
  }
}
