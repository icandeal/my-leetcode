package com.ycf.q109;

import com.ycf.q109.ListNode;
import com.ycf.q109.Solution;
import com.ycf.q109.TreeNode;
import org.junit.Test;

public class SolutionTest {

  ListNode listNode = new ListNode(
    -10, new ListNode(
      -3, new ListNode(
        0, new ListNode(
          5, new ListNode(
            9)))));
  Solution solution = new Solution();

  TreeNode treeNode = new TreeNode(0, new TreeNode(-3, new TreeNode(-10), null), new TreeNode(9, new TreeNode(5), null));

  @Test
  public void testDepth() {
    System.out.println(solution.depth(treeNode));
  }

  @Test
  public void test() {
    TreeNode treeNode = solution.sortedListToBST(listNode);
    String s = treeNode.preScan();
    System.out.println(s);
  }
}