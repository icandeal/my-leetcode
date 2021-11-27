package com.ycf.leetcode.q2;

/**
 * Created by yuchunfan on 2021/11/14
 */

public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  public void print() {
    System.out.print(val);
    if (next != null) {
      System.out.print(",");
      next.print();
    }
  }
}
