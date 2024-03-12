package com.ycf.q678;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author yuchunfan
 * @since 2024/3/11
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.checkValidString("()"));
    System.out.println(solution.checkValidString("(*)"));
    System.out.println(solution.checkValidString("(*))"));
    System.out.println(solution.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
  }

  public boolean checkValidString(String s) {
    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> starStack = new LinkedList<>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char aChar = chars[i];
      if (aChar == '(') {
        stack.push(i);
      } else if (aChar == '*') {
        starStack.push(i);
      } else {
        if (!stack.isEmpty()) {
          stack.pop();
        } else if (!starStack.isEmpty()) {
          starStack.pop();
        } else {
          return false;
        }
      }
    }
    while (!stack.isEmpty() && !starStack.isEmpty()) {
      Integer pop = stack.pop();
      Integer pop1 = starStack.pop();
      if (pop > pop1) {
        return false;
      }
    }
    return stack.isEmpty();
  }
}
