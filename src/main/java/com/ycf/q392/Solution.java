package com.ycf.q392;

/**
 * @author yuchunfan
 * @since 2024/3/8
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "abc", t = "ahbgdc";

    System.out.println(solution.isSubsequence(s, t));
    String s1 = "axc", t1 = "ahbgdc";
    System.out.println(solution.isSubsequence(s1, t1));
  }

  public boolean isSubsequence(String s, String t) {
    if (s.length() == 0) {
      return true;
    }
    int idx = 0;
    char c = s.charAt(idx);
    boolean finish = false;
    for (int i = 0; i < t.length(); i++) {
      char c1 = t.charAt(i);
      if (c1 == c) {
        if (++ idx >= s.length()) {
          finish = true;
          break;
        } else {
          c = s.charAt(idx);
        }
      }
    }
    return finish;
  }
}
