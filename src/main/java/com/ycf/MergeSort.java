package com.ycf;

public class MergeSort {

    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{6,3,8,7,1,9,4,2,5};
        mergeSort(a, 0, a.length -1, new int[a.length]);
        for (int i: a) {
            System.out.print(i + " ");
        }
        System.out.println();
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(2);
        ListNode n9 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        ListNode n = mergeSort(n1);
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int begin, int to, int[] tmp) {
        int half = (begin + to) / 2;
        if (half > begin) {
            mergeSort(arr, begin, half, tmp);
        }
        if (half + 1 < to) {
            mergeSort(arr, half + 1, to, tmp);
        }
        int a = begin, b = half + 1, idx = 0;
        while (a <= half && b <= to) {
            if (arr[a] <= arr[b]) {
                tmp[idx++] = arr[a++];
            } else {
                tmp[idx++] = arr[b++];
            }
        }
        while (a <= half) {
            tmp[idx++] = arr[a++];
        }
        while (b <= to) {
            tmp[idx++] = arr[b++];
        }
        idx = 0;
        while (begin <= to) {
            arr[begin ++] = tmp[idx++];
        }
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode half = slow.next;
        slow.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(half);

        ListNode pre = new ListNode(0);
        ListNode a = pre;

        while (left != null && right != null) {
            if (left.val > right.val) {
                a.next = right;
                right = right.next;
            } else {
                a.next = left;
                left = left.next;
            }
            a = a.next;
        }
        a.next = left == null ? right: left;

        return pre.next;
    }
}
