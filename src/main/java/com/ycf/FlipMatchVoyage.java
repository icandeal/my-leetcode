package com.ycf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuchunfan on 2020/6/28.
 *
 * LeetCode 971. 翻转二叉树以匹配先序遍历
 * 难度 中等
 */

public class FlipMatchVoyage {
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
        int[] voyage = new int[]{1,3,2};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        for (Integer i: flipMatchVoyage(root, voyage)) {
            System.out.println(i);
        }
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        TreeNode a = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < voyage.length - 1; i ++) {
            while (a == null && !stack.isEmpty()) {
                a = stack.pop().right;
            }
            if (a.val != voyage[i]) {
                list.clear();
                list.add(-1);
                break;
            }
            if (a.left != null && a.left.val != voyage[i + 1]) {
                list.add(a.val);
                TreeNode t = a.left;
                a.left = a.right;
                a.right = t;
            }
            stack.add(a);
            a = a.left;
        }
        return list;
    }
}
