package com.ycf.q129;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuchunfan
 * @since 2024/11/8
 */
public class Solution {


  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    n1.left = n2;
    n1.right = n3;

    Solution solution = new Solution();
    System.out.println(solution.sumNumbers(n1));
  }

  public int sumNumbers(TreeNode root) {
    // return doSum(root, 0);
    return bfs(root);
  }

  public int doSum(TreeNode node, int num) {
    if (node == null) {
      return 0;
    }

    num = 10 * num + node.val;

    return node.left == null && node.right == null ?
        num : doSum(node.left, num) + doSum(node.right, num);
  }

  public int bfs(TreeNode root) {
    Deque<TreeNode> nodes = new LinkedList<>();
    Deque<Integer> values = new LinkedList<>();

    nodes.add(root);
    values.add(root.val);
    int sum = 0;
    while (!nodes.isEmpty()) {

      for (int i = 0; i < nodes.size(); i++) {
        TreeNode node = nodes.poll();
        Integer val = values.poll();
        if (node.left == null && node.right == null) {
          sum += val;
          continue;
        }

        if (node.left != null) {
          nodes.add(node.left);
          values.add(val * 10 + node.left.val);
        }

        if (node.right != null) {
          nodes.add(node.right);
          values.add(val * 10 + node.right.val);
        }

      }
    }
    return sum;
  }
}
