package com.ycf;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by yuchunfan on 2020/7/7.
 *
 * 112. 路径总和
 * 难度 简单
 */
public class HasPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {

    }

//    public boolean hasPathSum(TreeNode root, int sum) {
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<Integer> sumStack = new Stack<>();
//        TreeNode node = root;
//        int s = 0;
//        while (node != null || stack.size() > 0) {
//            while (node != null) {
//                s += node.val;
//                stack.add(node);
//                sumStack.add(s);
//                node = node.left;
//            }
//
//            node = stack.pop().right;
//            s = sumStack.pop();
//            if (node == null && s == sum) {
//                return true;
//            }
//
//            while (node == null && stack.size() > 0) {
//                node = stack.pop().right;
//                s = sumStack.pop();
//            }
//        }
//        return false;
//    }

    public boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if (sum == 0)
                return true;
            return false;
        }
        sum -= node.val;
        if (hasPathSum(node.left, sum))
            return true;
        if (hasPathSum(node.right, sum))
            return true;

        return false;
    }
}
