package com.ycf.q17;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuchunfan
 * @since 2024/12/4
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.letterCombinations("23"));
  }
  String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  List<String> res = new LinkedList<>();
  StringBuilder sb = new StringBuilder();
  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() < 1) {
      return Arrays.asList("");
    }
    combine(digits, 0);
    return res;
  }

  public void combine(String digits, int idx) {
    if (idx == digits.length()) {
      res.add(sb.toString());
      return;
    }
    String chars = strs[digits.charAt(idx) - '0'];
    for (int i = 0; i < chars.length(); i++) {
      sb.append(chars.charAt(i));
      combine(digits, idx + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
