package com.ycf.leetcode.q109;

import java.util.Stack;

/**
 * Created by yuchunfan on 2022/2/9
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
  public TreeNode sortedListToBST(ListNode head) {

    TreeNode treeNode = null;
    ListNode curr = head;
    while (curr != null) {
      treeNode = insertNode(treeNode, curr.val);
      curr = curr.next;
    }

    return treeNode;
  }

  public int depth(TreeNode treeNode) {
    if (treeNode == null)
      return 0;
    return 1 + Math.max(depth(treeNode.left), depth(treeNode.right));
  }

  public TreeNode insertNode(TreeNode treeNode, int i) {
    if (treeNode == null) {
      return new TreeNode(i);
    }
    if (treeNode.val == i) {
      return treeNode;
    } else if (treeNode.val > i) {
      treeNode.left = insertNode(treeNode.left, i);
      int l = depth(treeNode.left);
      int r = depth(treeNode.right);
      if (Math.abs(l - r) > 1) {
        if (l > r)  treeNode = covertLL(treeNode);
        else treeNode = covertLR(treeNode);
      }
    } else {
      treeNode.right = insertNode(treeNode.right, i);
      int l = depth(treeNode.left);
      int r = depth(treeNode.right);
      if (Math.abs(l - r) > 1) {
        if (l > r)  treeNode = covertRL(treeNode);
        else treeNode = covertRR(treeNode);
      }
    }
    return treeNode;
  }

  public TreeNode covertRR(TreeNode treeNode) {
    TreeNode child = treeNode.right;
    TreeNode tmp = child.left;
    child.left = treeNode;
    treeNode.right = tmp;
    return child;
  }

  public TreeNode covertLL(TreeNode treeNode) {
    TreeNode child = treeNode.left;
    TreeNode tmp = child.right;
    child.right = treeNode;
    treeNode.left = tmp;
    return child;
  }

  public TreeNode covertRL(TreeNode treeNode) {
    TreeNode child = treeNode.right;
    TreeNode t = child.left;
    TreeNode tmpL = t.left;
    TreeNode tmpR = t.right;
    t.left = treeNode;
    t.right = child;
    treeNode.right = tmpL;
    child.left = tmpR;
    return t;
  }

  public TreeNode covertLR(TreeNode treeNode) {
    TreeNode child = treeNode.left;
    TreeNode t = child.right;
    TreeNode tmpL = t.left;
    TreeNode tmpR = t.right;
    t.left = child;
    t.right = treeNode;
    treeNode.left = tmpR;
    child.right = tmpL;
    return t;
  }
}

