package com.ycf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuchunfan on 2020/7/1.
 *
 * Leetcode 113. 路径总和 II
 * 难度 中等
 */
public class PathSum {

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
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t8 = new TreeNode(8);
        TreeNode t11 = new TreeNode(11);
        TreeNode t13 = new TreeNode(13);
        TreeNode t44 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t2 = new TreeNode(2);
        TreeNode t55 = new TreeNode(5);
        TreeNode t1 = new TreeNode(5);
//        TreeNode t24 = new TreeNode(4);

        t5.left = t4;
        t5.right = t8;
        t4.left = t11;
        t8.left = t13;
        t8.right = t44;
        t11.left = t7;
        t11.right = t2;
        t44.left = t55;
        t44.right = t1;
//        t1.left = t24;

        for (List<Integer> path: pathSum(t5, 22)) {
            for (Integer i:path) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, sum, new ArrayList<>(), res);
        return res;
    }

    public void pathSum(TreeNode node, int sum, List<Integer> path, List<List<Integer>> res) {
        if (node == null)
            return;
        List<Integer> p = new ArrayList<>(path);
        p.add(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null) {
            if (sum == 0)
                res.add(p);
            return;
        }
        pathSum(node.left, sum, p, res);
        pathSum(node.right, sum, p, res);
    }
}
