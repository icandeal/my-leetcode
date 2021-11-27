package com.ycf.leetcode.q2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
  ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
  ListNode l2 = new ListNode(9, new ListNode(9));

  @Test
  public void test() {
    Solution solution = new Solution();
    ListNode listNode = solution.addTwoNumbers(l1, l2);
    listNode.print();
  }
}