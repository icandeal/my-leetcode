package com.ycf.q105;

import com.ycf.LeetcodeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuchunfan
 * @since 2024/4/10
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] preorder = LeetcodeUtils.parseIntArray("[3,9,20,15,7]");
    int[] inorder = LeetcodeUtils.parseIntArray("[9,3,15,20,7]");
    TreeNode treeNode = solution.buildTree(preorder, inorder);

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

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      int n = inorder[i];
      indexMap.put(n, i);
    }
    return buildTree(preorder, 0, 0, preorder.length - 1, indexMap);
  }

  public TreeNode buildTree(int[] preorder, int idx, int l, int r, Map<Integer, Integer> indexMap) {
    if (l > r) {
      return null;
    }
    int cur = preorder[idx];
    Integer inIndex = indexMap.get(cur);

    TreeNode root = new TreeNode(cur);
    if (inIndex > l) {
      root.left = buildTree(preorder, idx + 1, l, inIndex - 1, indexMap);
    }

    if (inIndex < r) {
      root.right = buildTree(preorder, idx + inIndex - l + 1, inIndex + 1, r, indexMap);
    }
    return root;
  }
}
