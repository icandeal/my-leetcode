package com.ycf.q106;

import com.ycf.LeetcodeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuchunfan
 * @since 2024/11/8
 */
public class Solution {

  public static void main(String[] args) {
//    输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//    输出：[3,9,20,null,null,15,7]
    int[] inorder = LeetcodeUtils.parseIntArray("[9,3,15,20,7]");
    int[] postorder = LeetcodeUtils.parseIntArray("[9,15,7,20,3]");

    Solution solution = new Solution();
    solution.buildTree(inorder, postorder);
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
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }
    return buildTree(postorder, postorder.length - 1, 0, postorder.length - 1, inMap);
  }
  
  public TreeNode buildTree(int[] postorder, int index, int l, int r, Map<Integer, Integer> inMap) {
    if (l > r || index < 0 || index >= postorder.length) {
      return null;
    }
    int cur = postorder[index];
    Integer curIdx = inMap.get(cur);

    TreeNode root = new TreeNode(cur);
    if (curIdx < r) {
      root.right = buildTree(postorder, index - 1, curIdx + 1, r, inMap);
    }

    if (curIdx > l) {
      root.left = buildTree(postorder, index - 1 - r + curIdx, l, curIdx - 1, inMap);
    }

    return root;
  }
}
