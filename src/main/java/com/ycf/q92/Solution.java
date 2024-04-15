package com.ycf.q92;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuchunfan
 * @since 2024/4/3
 */

public class Solution {
  public static void main(String[] args) {

  }

  public ListNode reverseBetween(ListNode head, int left, int right) {
    Deque<ListNode> deque = new LinkedList<>();
    int i = 0;
    ListNode root = new ListNode();
    root.next = head;
    ListNode now = root;
    ListNode before = null;
    ListNode end;
    while (root.next != null && i < right) {
      i++;
      if (i == left) {
        before = now;
      }
      now = now.next;
      if (i >= left && i <= right) {
        deque.push(now);
      }

      if (i == right) {
        end = now.next;
        while (!deque.isEmpty()) {
          before.next = deque.pop();
          before = before.next;
        }
        before.next = end;
        break;
      }
    }

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
