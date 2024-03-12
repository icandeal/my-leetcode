package com.ycf.q2;



public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int up = 0;
    ListNode head = l1;
    if (l1 == null) l1 = new ListNode();
    if (l2 == null) l2 = new ListNode();
    while (true) {
      int sum = l1.val + l2.val + up;
      up = sum / 10;
      l1.val = sum % 10;

      if (l1.next == null && l2.next == null && up == 0) break;
      if (l1.next == null) {
        l1.next = new ListNode();
      }
      l1 = l1.next;
      l2 = l2.next == null? new ListNode(): l2.next;
    }
    return head;
  }
}
