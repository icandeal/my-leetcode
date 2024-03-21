package com.ycf.q100;

/**
 * @author yuchunfan
 * @since 2024/3/19
 */

public class Solution {

  public boolean isSameTree(TreeNode p, TreeNode q) {

    if (p == null && q == null) {
      return true;
    } else if ((p == null || q == null) || p.val != q.val) {
      return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
