package com.ycf.q139;

import com.ycf.LeetcodeUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author yuchunfan
 * @since 2024/3/28
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual(true, solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
    LeetcodeUtils.testEqual(true, solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    LeetcodeUtils.testEqual(false, solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>();
    set.addAll(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (set.contains(s.substring(j, i)) && dp[j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public boolean wordBreakTimeout(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    return wb(s, 0, set);
  }

  public boolean wb(String s, int start, Set<String> set) {
    if (start >= s.length()) {
      return true;
    }
    for (int i = start + 1; i <= s.length(); i++) {
      String s1 = s.substring(start, i);
      if (set.contains(s1) && wb(s, i, set)) {
        return true;
      }
    }
    return false;
  }


}
