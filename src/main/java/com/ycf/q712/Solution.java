package com.ycf.q712;

/**
 * @author yuchunfan
 * @since 2024/3/11
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

  }

  public int minimumDeleteSum(String s1, String s2) {
    int iLen = s1.length();
    int jLen = s2.length();

    char[] s1Chars = s1.toCharArray();
    char[] s2Chars = s2.toCharArray();
    int[][] dp = new int[iLen + 1][jLen + 1];
    for (int i = 1; i <= iLen; i++) {
      dp[i][0] = dp[i - 1][0] + s1Chars[i - 1];
    }

    for (int j = 1; j <= jLen; j++) {
      dp[0][j] = dp[0][j - 1] + s2Chars[j - 1];
    }
    for (int i = 1; i <= iLen; i++) {
      char s1Char = s1Chars[i - 1];
      for (int j = 1; j <= jLen; j++) {
        char s2Char = s2Chars[j - 1];
        if (s1Char == s2Char) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j] + s1Char, dp[i][j - 1] + s2Char);
        }
      }
    }
    return dp[iLen][jLen];
  }
}
