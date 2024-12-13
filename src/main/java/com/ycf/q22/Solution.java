package com.ycf.q22;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yuchunfan
 * @since 2024/12/13
 */
public class Solution {

  List<String> result = new LinkedList<>();
  StringBuilder sb = new StringBuilder();
  int left = 0;
  int right = 0;

  public List<String> generateParenthesis(int n) {
    generate(n);
    return result;
  }

  public void generate(int n) {
    if (sb.length() >= 2 * n) {
      result.add(sb.toString());
      return;
    }

    if (left < n) {
      left++;
      sb.append("(");
      generate(n);
      left--;
      sb.deleteCharAt(sb.length() - 1);
    }

    if (right < n && right < left) {
      right ++;
      sb.append(")");
      generate(n);
      right --;
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
