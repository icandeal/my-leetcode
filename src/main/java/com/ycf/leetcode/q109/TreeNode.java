package com.ycf.leetcode.q109;

/**
 * Created by yuchunfan on 2022/2/9
 */

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  public TreeNode() {}
  public TreeNode(int val) { this.val = val; }
  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public String preScan() {
    return val + ", " + (left == null? "": left.preScan()) + ", "+(right == null?"": right.preScan());
  }
}