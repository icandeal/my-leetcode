package com.ycf.q509;

/**
 * @author yuchunfan
 * @since 2024/3/8
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.fib(2));
  }

  public int fib(int n) {
    if (n == 0) {
      return 0;
    }
    int p = 0, q = 0, r = 1;
    for (int i = 1; i < n; i++) {
      p = q;
      q = r;
      r = p + q;
    }
    return r;
  }
}
