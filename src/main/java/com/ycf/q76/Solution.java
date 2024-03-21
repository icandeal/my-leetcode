package com.ycf.q76;

import com.ycf.LeetcodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yuchunfan
 * @since 2024/3/15
 */

public class Solution {
  public static void main(String[] args) {
    String s = "ADOBECODEBANC", t = "ABC";
    Solution solution = new Solution();
    LeetcodeUtils.testEqual("BANC", solution.minWindow(s, t));
  }

  public String minWindow(String s, String t) {
    int[] num = new int[26];
    int tLen = t.length();
    Set<Character> characters = new HashSet<>();
    for (int i = 0; i < tLen; i++) {
      char c = t.charAt(i);
      num[c - 'a'] ++;
      characters.add(c);
    }
    char[] base = s.toCharArray();

    int left = 0, right = -1;
    int sum = tLen;
    String minStr = null;
    while (left < s.length() && right < s.length()) {
      System.out.println("left: " + left + ", right: " + right + " >>> " + LeetcodeUtils.arrayToString(num));
      if (sum > 0) {
        right ++;
        char c = base[right];
        if (characters.contains(c)) {
          if (num[c - 'a'] > 0) {
            sum --;
          }
          num[c - 'a'] --;
        }
      } else {
        String substring = s.substring(left, right + 1);
        if (minStr == null) {
          minStr = substring;
        } else if (minStr.length() > substring.length()) {
          
        }
        left ++;
      }
    }
    return minStr;
  }
}
