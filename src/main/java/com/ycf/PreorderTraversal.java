package com.ycf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuchunfan on 2020/7/8.
 *
 * LeetCode 144. 二叉树的前序遍历
 * 难度 中等
 */
public class PreorderTraversal {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        result.add(node.val);
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }
}
