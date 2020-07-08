package com.ycf;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuchunfan on 2020/6/29.
 *
 * LeetCode 199. 二叉树的右视图
 * 难度 中等
 */
public class RightSideView {

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
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        root.left = n2;
        root.right = n3;
        n2.right = n5;
        n3.right = n4;

        for (Integer i: rightSideView(root)) {
            System.out.println(i);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> dp = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        queue.add(root);
        dp.add(1);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            int h = dp.poll();
            if (node.right != null) {
                queue.add(node.right);
                dp.add(h + 1);
                if (res.size() == h) {
                    res.add(node.right.val);
                }
            }
            if (node.left != null) {
                queue.add(node.left);
                dp.add(h + 1);
                if (res.size() == h) {
                    res.add(node.left.val);
                }
            }
        }
        return res;
    }
}
