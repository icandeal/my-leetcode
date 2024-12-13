package com.ycf.q117;

import java.util.*;

/**
 * @author yuchunfan
 * @since 2024/11/8
 */
public class Solution {
  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node7 = new Node(7);
    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.right = node7;

    Solution solution = new Solution();
    System.out.println(solution.connect(node1));
  }

  public Node connect(Node root) {
//    LinkedList<Node> nodes = new LinkedList<>();
//    nodes.add(root);
//    bfs(nodes);

    bfsPlus(root);

//    List<Node> nodes = new ArrayList<>();
//    dfs(nodes, root, 0);

    return root;
  }

  public void dfs(List<Node> depthList, Node node, int depth) {
    if (node == null) {
      return;
    }
    if (depthList.size() == depth) {
      depthList.add(node);
    } else {
      Node last = depthList.get(depth);
      last.next = node;
      depthList.set(depth, node);
    }
    dfs(depthList, node.left, depth + 1);
    dfs(depthList, node.right, depth + 1);
  }

  public void bfs(Deque<Node> nodes) {
    Node last = null;
    Deque<Node> deque = new LinkedList<>();
    for (Node node : nodes) {
      if (last != null) {
        last.next = node;
      }
      last = node;
      if (node.left != null) {
        deque.add(node.left);
      }
      if (node.right != null) {
        deque.add(node.right);
      }
    }
    if (!deque.isEmpty()) {
      bfs(deque);
    }
  }


  public void bfsPlus(Node root) {
    Node head = new Node();
    head.next = root;
    while (head.next != null) {
      Node cur = head.next;
      Node h = head;
      head.next = null;
      while (cur != null) {
        if (cur.left != null) {
          head.next = cur.left;
          head = head.next;
        }
        if (cur.right != null) {
          head.next = cur.right;
          head = head.next;
        }
        cur = cur.next;
      }
      head = h;
    }
  }
}
