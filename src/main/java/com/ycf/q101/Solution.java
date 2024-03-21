package com.ycf.q101;

/**
 * @author yuchunfan
 * @since 2024/3/19
 */

public class Solution {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return testSymmetric(root.left, root.right);
  }

  public boolean testSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null || left.val != right.val) {
      return false;
    }

    return testSymmetric(left.left, right.right) && testSymmetric(left.right, right.left);
  }

  public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
