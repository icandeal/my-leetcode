package com.ycf.q226;

/**
 * @author yuchunfan
 * @since 2024/3/19
 */

public class Solution {


  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode tmp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(tmp);
    return root;
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
