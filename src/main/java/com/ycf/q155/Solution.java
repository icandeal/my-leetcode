package com.ycf.q155;

import com.ycf.LeetcodeUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yuchunfan
 * @since 2024/4/3
 */

public class Solution {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    LeetcodeUtils.testEqual(-3, minStack.getMin());
    minStack.pop();
    LeetcodeUtils.testEqual(0, minStack.top());
    LeetcodeUtils.testEqual(-2, minStack.getMin());
  }

  public static class MinStack {

    List<Integer> list;
    List<Integer> minList;

    public MinStack() {
      list = new LinkedList<>();
      minList = new LinkedList<>();
      minList.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
      list.add(0, val);
      Integer min = minList.get(0);
      minList.add(0, min > val ? val : min);
    }

    public void pop() {
      list.remove(0);
      minList.remove(0);
    }

    public int top() {
      return list.get(0);
    }

    public int getMin() {
      return minList.get(0);
    }
  }
}
