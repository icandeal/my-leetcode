package com.ycf.q114;

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

  public void flatten(TreeNode root) {
    flatten5(root);
  }

  public void flatten1(TreeNode root) {
    List<TreeNode> treeNodes = new LinkedList<>();
    dfs(treeNodes, root);

    TreeNode head = null;
    for (TreeNode node : treeNodes) {
      if (head != null) {
        head.left = null;
        head.right = node;
      }
      head = node;
    }

  }

  public void dfs(List<TreeNode> list, TreeNode root) {
    if (root == null) {
      return;
    }

    list.add(root);
    dfs(list, root.left);
    dfs(list, root.right);
  }

  public void flatten2(TreeNode root) {
    toRight(root);
  }

  public TreeNode toRight(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode leftToRight = toRight(root.left);
    TreeNode rightToRight = toRight(root.right);
    if (leftToRight != null) {
      root.left = null;
      root.right = leftToRight;
      while (leftToRight.right != null) {
        leftToRight = leftToRight.right;
      }
      leftToRight.right = rightToRight;
    } else {
      root.right = rightToRight;
    }
    return root;
  }

  public void flatten3(TreeNode root) {
    while (root != null) {
      if (root.left == null) {
        root = root.right;
      } else {
        TreeNode tmp = root.left;
        while (tmp.left != null || tmp.right != null) {
          tmp = tmp.right == null ? tmp.left : tmp.right;
        }
        tmp.right = root.right;
        root.right = root.left;
        root.left = null;
        root = root.right;
      }
    }
  }

  TreeNode pre = null;

  public void flatten4(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten4(root.right);
    flatten4(root.left);
    root.right = pre;
    root.left = null;
    pre = root;
  }

  public void flatten5(TreeNode root) {
    if (root == null) {
      return;
    }
    Deque<TreeNode> deque = new LinkedList<>();
    TreeNode pre = root;
    while (!deque.isEmpty() || pre != null) {
      if (pre.left != null) {
        if (pre.right != null) {
          deque.push(pre.right);
        }
        pre.right = pre.left;
        pre.left = null;
      }

      if (pre.right == null && !deque.isEmpty()) {
        pre.right = deque.pop();
      }
      pre = pre.right;
    }
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    TreeNode t6 = new TreeNode(6);
    t1.left = t2;
    t2.left = t3;
    t2.right = t4;
    t1.right = t5;
    t5.right = t6;

    Solution solution = new Solution();
    solution.flatten5(t1);
  }
}
