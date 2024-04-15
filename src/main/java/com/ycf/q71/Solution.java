package com.ycf.q71;

import com.ycf.LeetcodeUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuchunfan
 * @since 2024/4/2
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual("/home", solution.simplifyPath("/home/"));
    LeetcodeUtils.testEqual("/c", solution.simplifyPath("/a/./b/../../c/"));
    LeetcodeUtils.testEqual("/...", solution.simplifyPath("/..."));
    LeetcodeUtils.testEqual("/", solution.simplifyPath("/.."));
  }

  public String simplifyPath(String path) {
    Deque<Character> deque = new LinkedList<>();
    String p = path + '/';
    int point = 0;
    int cnt = 0;
    for (int i = 0; i < p.length(); i++) {
      char c = p.charAt(i);
      if (c == '.') {
        deque.push(c);
        point++;
      } else if (c == '/') {
        if (cnt == 0 && (point == 1 || point == 2)) {
          while (point > 0 && !deque.isEmpty()) {
            char pop = deque.pop();
            if (pop == '/') {
              point --;
            }
          }
        }
        cnt = 0;
        point = 0;
        if (deque.isEmpty() || deque.peek() != '/') {
          deque.push(c);
        }
      } else {
        deque.push(c);
        cnt++;
      }
    }

    if (deque.size() > 1) {
      deque.pop();
    }

    StringBuilder sb = new StringBuilder();
    while (!deque.isEmpty()) {
      sb.append(deque.pollLast());
    }
    return sb.toString();
  }
}
