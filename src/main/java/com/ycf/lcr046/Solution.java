package com.ycf.lcr046;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 @author yuchunfan
 @since 2024/3/8
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode treeNode = new TreeNode();
    List<Integer> integers = solution.rightSideView(treeNode);
    integers.forEach(System.out::println);
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    rightSideDFS(root, result, 0);
    return result;
  }

  public void rightSideDFS(TreeNode treeNode, List<Integer> result, int level) {
    if (treeNode == null) {
      return;
    }

    if (result.size() <= level || result.get(level) == null) {
      result.add(level, treeNode.val);
    }

    rightSideDFS(treeNode.right, result, level + 1);
    rightSideDFS(treeNode.left, result, level + 1);
  }

  public void bfs(TreeNode treeNode, List<Integer> result) {
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> depthQueue = new LinkedList<>();
    if (treeNode != null) {
      queue.add(treeNode);
      depthQueue.add(0);
    }
    while (!queue.isEmpty()) {
      TreeNode poll = queue.poll();
      Integer depth = depthQueue.poll();
      if (poll == null) {
        continue;
      }

      if (result.size() > depth) {
        result.set(depth, poll.val);
      } else {
        result.add(poll.val);
      }

      queue.add(poll.left);
      depthQueue.add(depth + 1);
      queue.add(poll.right);
      depthQueue.add(depth + 1);
    }
  }

  public static class TreeNode {
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

