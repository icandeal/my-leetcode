package com.ycf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuchunfan on 2020/6/29.
 *
 * LeetCode 872. 叶子相似的树
 * 难度 简单
 */
public class LeafSimilar {

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

        root.left = n2;
        n2.right = n3;

        List<Integer> leafList = new ArrayList<>();
        findLeafRecursive(root, leafList);
        for (Integer i: leafList) {
            System.out.println(i);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = findLeaf(root1);
        List<Integer> l2 = findLeaf(root2);
        if (l1.size() != l2.size())
            return false;
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i))
                return false;
        }
        return true;
    }

    public void findLeafRecursive(TreeNode node, List<Integer> leafList) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            leafList.add(node.val);
            return;
        }
        findLeafRecursive(node.left, leafList);
        findLeafRecursive(node.right, leafList);
    }

    public List<Integer> findLeaf(TreeNode root) {
        Stack<TreeNode>  stack = new Stack<>();
        TreeNode a = root;
        List<Integer> intList = new ArrayList<>();
        while (a != null || stack.size() > 0) {
            if (a != null) {
                stack.add(a);
                a = a.left;
            } else {
                a = stack.pop();
                if (a.right == null && a.left == null)
                    intList.add(a.val);
                a = a.right;
            }
        }
        return intList;
    }
}
