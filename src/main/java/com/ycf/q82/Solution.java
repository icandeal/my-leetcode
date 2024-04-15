package com.ycf.q82;

/**
 * @author yuchunfan
 * @since 2024/4/3
 */

public class Solution {
  public static void main(String[] args) {

  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode root = new ListNode();
    root.next = head;
    ListNode pre = root;
    ListNode now = pre.next;
    while (now != null) {
      int val = now.val;
      if (now.next != null && now.next.val == val) {
        while (now != null && now.val == val) {
          now = now.next;
        }
        pre.next = now;
      } else {
        pre = now;
        now = now.next;
      }
    }
    return root.next;
  }

   public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
