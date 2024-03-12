package com.ycf.q2;

import com.ycf.q2.ListNode;
import com.ycf.q2.Solution;
import org.junit.Test;

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