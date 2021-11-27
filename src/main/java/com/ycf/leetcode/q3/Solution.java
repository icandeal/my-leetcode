package com.ycf.leetcode.q3;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuchunfan on 2021/11/15
 */

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) return 0;
    Set<Character> set = new HashSet<>();
    int left = 0, max = 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!set.contains(c)) {
        set.add(c);
      } else {
        max = set.size() > max? set.size(): max;
        for (; left < i; left++) {
          char c1 = s.charAt(left);
          if (c1 != c)
            set.remove(c1);
          else {
            left ++;
            break;
          }
        }
      }
    }
    return set.size() > max? set.size(): max;
  }
}
