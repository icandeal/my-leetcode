package com.ycf.q70;

/**
 * @author yuchunfan
 * @since 2024/3/8
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 3;
    System.out.println(solution.climbStairs(n));
  }

  public int climbStairs(int n) {
    int p = 0, q = 0, r = 1;
    for (int i = 1; i <= n; i++) {
      p = q;
      q = r;
      r = p + q;
    }
    return r;
  }
}
