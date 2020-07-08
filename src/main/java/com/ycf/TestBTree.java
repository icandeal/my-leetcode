package com.ycf;

import java.util.Stack;

public class TestBTree {

    public static void main(String[] args) {
        BTree2 bTree = new BTree2(20);
        bTree.put(5);
        bTree.put(6);
        bTree.put(7);
        bTree.put(23);
        bTree.put(2);
        bTree.put(8);
        bTree.put(15);
        bTree.put(29);
        bTree.put(31);
        bTree.put(3);
        bTree.put(24);
        bTree.print();
        System.out.println(bTree.getHight());
    }
    
    public static class BTree2 {

        private class Node {
            public int val;
            public Node left;
            public Node right;

            public Node(int val) {
                this.val = val;
            }
        }

        public Node root;

        public BTree2(int val) {
            this.root = new Node(val);
        }
        
        public void put(int n) {
            Node p = searchParent(n, root);
            if (p != null && p.val > n && p.left == null)
                p.left = new Node(n);
            if (p != null && p.val < n && p.right == null)
                p.right = new Node(n);

            if (p.val != root.val) {
                balance(p);
            }

//            while (a != null) {
//                if (n > a.val) {
//                    if (a.right != null)
//                        a = a.right;
//                    else {
//                        a.right = new Node(n);
//                        break;
//                    }
//                } else if (n < a.val) {
//                    if (a.left != null)
//                        a = a.left;
//                    else {
//                        a.left = new Node(n);
//                        break;
//                    }
//                }
//            }
        }

        private Node searchParent(int a, Node n) {
            if (a > n.val) {
                if (n.right != null && n.right.val != a) {
                    return searchParent(a, n.right);
                } else
                    return n;
            } else if (a < n.val) {
                if (n.left != null && n.left.val != a) {
                    return searchParent(a, n.left);
                } else
                    return n;
            } else return null;
        }

        private void balance(Node n) {
            Node pre = searchParent(n.val, root);
            int left = getHight(pre.left);
            int right = getHight(pre.right);
            Node newPre = pre;
            if (left - right >=2) {
                if (n.right != null) {
                    Node tmp = n.right;
                    n.right = tmp.left;
                    pre.left = tmp.right;
                    tmp.left = n;
                    tmp.right = pre;
                    newPre = tmp;
                } else {
                    pre.left = n.right;
                    n.right = pre;
                    newPre = n;
                }
            } else if (right - left >=2) {
                if (n.left != null) {
                    Node tmp = n.left;
                    n.left = tmp.right;
                    pre.right = tmp.left;
                    tmp.right = n;
                    tmp.left = pre;
                    newPre = tmp;
                } else {
                    pre.right = n.left;
                    n.left = pre;
                    newPre = n;
                }
            }
            if (pre.val == root.val)
                root = newPre;
        }
        
        public void print() {
            Stack<Node> stack = new Stack<>();
            Node n = root;
            while (true) {
                while (n != null) {
                    stack.add(n);
                    n = n.left;
                }
                if (!stack.isEmpty()) {
                    n = stack.pop();
                    System.out.print(n.val);
                    System.out.print("\t");
                    n = n.right;
                } else {
                    break;
                }
            }
            System.out.println();
        }

        public int getHight(){
            return getHight(root);
        }

        private int getHight(Node n) {
            if (n == null) {
                return 0;
            }
            int lh = 1 + getHight(n.left);
            int rh = 1 + getHight(n.right);
            return lh > rh? lh: rh;
        }
    }
}
