package com.ycf.q61;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuchunfan
 * @since 2024/4/3
 */

public class Solution {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    ListNode root = new ListNode();
    root.next = head;

    ListNode next = root;
    Deque<ListNode> deque = new LinkedList<>();
    while (next.next != null) {
      next = next.next;
      deque.push(next);
    }
    k = k % deque.size();
    ListNode pop = head;
    for (int i = 0; i < k; i++) {
      pop = deque.pop();
    }
    next.next = head;
    deque.pop().next = null;
    return pop;
  }
}
