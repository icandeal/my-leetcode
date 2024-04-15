package com.ycf.q150;

import com.ycf.LeetcodeUtils;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author yuchunfan
 * @since 2024/4/3
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual(9, solution.evalRPN(LeetcodeUtils.parseStringArray("[\"2\",\"1\",\"+\",\"3\",\"*\"]")));
  }

  public int evalRPN(String[] tokens) {
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < tokens.length; i++) {
      String token = tokens[i];
      switch (token) {
        case "+":
          deque.push(deque.pop() + deque.pop());
          break;
        case "-":
          int i2 = deque.pop();
          int i1 = deque.pop();
          deque.push(i1 - i2);
          break;
        case "*":
          deque.push(deque.pop() * deque.pop());
          break;
        case "/":
          int d2 = deque.pop();
          int d1 = deque.pop();
          deque.push(d1 / d2);
          break;
        default:
          deque.push(Integer.parseInt(token));
      }
    }
    return deque.pop();
  }
}
