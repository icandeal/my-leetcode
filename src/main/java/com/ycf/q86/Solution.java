package com.ycf.q86;

/**
 * @author yuchunfan
 * @since 2024/12/3
 */
public class Solution {
   public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

  public ListNode partition(ListNode head, int x) {
    ListNode small = new ListNode();
    ListNode smallEnd = small;
    ListNode large = new ListNode();
    ListNode largeEnd = large;

    while (head != null) {
      if (head.val < x) {
        smallEnd.next = head;
        smallEnd = smallEnd.next;
        head = head.next;
        smallEnd.next = null;
      } else {
        largeEnd.next = head;
        largeEnd = largeEnd.next;
        head = head.next;
        largeEnd.next = null;
      }
    }
    if (large.next != null) {
      smallEnd.next = large.next;
    }
    return small.next;
  }

  public ListNode partition1(ListNode head, int x) {
     if (head == null) {
       return null;
     }
     ListNode root = new ListNode();
     ListNode rootEnd = root;
     ListNode tail = new ListNode();
     ListNode tailEnd = tail;

     while (rootEnd.next != null) {
       if (rootEnd.next.val < x) {
         tailEnd.next = rootEnd.next;
         rootEnd.next = rootEnd.next.next;
         tailEnd = tailEnd.next;
         tailEnd.next = null;
       } else {
         rootEnd = rootEnd.next;
       }
     }
     if (root.next != null) {
       tailEnd.next = root.next;
     }
     return tail.next;
  }
}
