package com.ycf.q19;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuchunfan
 * @since 2024/4/3
 */

public class Solution {

  public static void main(String[] args) {

  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    Deque<ListNode> deque = new LinkedList<>();
    ListNode root = new ListNode();
    root.next = head;
    ListNode now = root;
    while (now != null) {
      deque.push(now);
      now = now.next;
    }

    ListNode next = null;
    for (int i = 1; i < n; i++) {
      next = deque.pop();
    }
    deque.pop();
    deque.pop().next = next;
    return root.next;
  }

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
}
