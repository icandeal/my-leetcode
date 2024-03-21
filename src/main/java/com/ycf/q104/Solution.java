package com.ycf.q104;

/**
 * @author yuchunfan
 * @since 2024/3/19
 */

public class Solution {

  public static void main(String[] args) {

  }

  public int maxDepth(TreeNode root) {
    return getDepth(root);
  }

  public int getDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    return 1 + Math.max(getDepth(node.left), getDepth(node.right));
  }

  public class TreeNode {
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
}
