package com.ycf.q62;

import com.ycf.LeetcodeUtils;

/**
 * @author yuchunfan
 * @since 2024/3/21
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual(3, solution.uniquePaths(3, 2));
    LeetcodeUtils.testEqual(28, solution.uniquePaths(7, 3));
  }

  public int uniquePaths(int m, int n) {
     int[][] path = new int[m][n];
    for (int i = 0; i < m; i++) {
      path[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      path[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        path[i][j] = path[i - 1][j] + path[i][j - 1];
      }
    }
    return path[m - 1][n - 1];
  }
}
