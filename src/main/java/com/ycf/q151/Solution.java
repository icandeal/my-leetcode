package com.ycf.q151;

import com.ycf.LeetcodeUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuchunfan
 * @since 2024/11/29
 */
public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual("blue is sky the", solution.reverseWords2("the sky is blue"));
    LeetcodeUtils.testEqual("world hello", solution.reverseWords2("  hello world  "));
    LeetcodeUtils.testEqual("example good a", solution.reverseWords2("a good   example"));
  }
  public String reverseWords(String s) {
    Deque<String> deque = new LinkedList<>();
    StringBuilder builder = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        if (builder.length() > 0) {
          deque.push(builder.toString());
          builder = new StringBuilder();
        }
      } else {
        builder.append(c);
      }
    }
    if (builder.length() > 0) {
      deque.push(builder.toString());
    }
    builder = new StringBuilder();
    while (!deque.isEmpty()) {
      builder.append(deque.pop());
      if (!deque.isEmpty()) {
        builder.append(" ");
      }
    }
    return builder.toString();
  }

  public String reverseWords2(String s) {
    String[] split = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = split.length - 1; i >= 0; i--) {
      String s1 = split[i];
      if (!s1.isEmpty()) {
        sb.append(s1);
        sb.append(' ');
      }
    }
    if (sb.charAt(sb.length() - 1) ==' ') {
      sb.deleteCharAt(sb.length() - 1);
    }
    return sb.toString();
  }
}
