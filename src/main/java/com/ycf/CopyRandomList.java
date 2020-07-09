package com.ycf;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuchunfan on 2020/7/8.
 *
 * LeetCode 138. 复制带随机指针的链表
 * 难度 中等
 */
public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //[[7,null],[13,0],[11,4],[10,2],[1,0]]
    @Test
    public void test() {
        Node head = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        head.next = n1;
        n1.next = n2;
        n1.random = head;
        n2.next = n3;
        n2.random = n4;
        n3.next = n4;
        n3.random = n2;
        n4.random = head;
        Node m = head;
        while (m != null) {
            System.out.print("["+m.val+ ","+ (m.random == null? "null" : m.random.val)+ "]");
            m = m.next;
        }

        System.out.println();
        Node n = copyRandomList(head);

        while (n != null) {
            System.out.print("["+n.val+ ","+ (n.random == null? "null" : n.random.val)+ "]");
            n = n.next;
        }

        System.out.println();
        n = copyRandomList2(head);

        while (n != null) {
            System.out.print("["+n.val+ ","+ (n.random == null? "null" : n.random.val)+ "]");
            n = n.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node n = head;
        while (n != null) {
            Node a = new Node(n.val);
            a.next = n.next;
            n.next = a;
            n = a.next;
        }

        n = head;
        Node root = n.next;
        while (n != null) {
            if (n.random != null)
                n.next.random = n.random.next;
            n = n.next.next;
        }

        n = head;
        Node m = root;
        while (n != null) {
            n.next = m.next;
            n = n.next;
            if (n != null) {
                m.next = n.next;
                m = m.next;
            }
        }
        return root;
    }

    public Node copyRandomList2(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        Node m = head;
        Node root = new Node(m.val);
        Node n = root;

        map.put(m, n);

        while (m.next != null) {
            m = m.next;
            Node a = new Node(m.val);
            n.next = a;
            n = n.next;
            map.put(m, n);
        }
        m = head;
        n = root;
        while (m != null) {
            if (m.random != null)
                n.random = map.get(m.random);
            m = m.next;
            n = n.next;
        }
        return root;
    }
}
