package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/3.
 *
 * 108. 将有序数组转换为二叉搜索树
 * 难度 简单
 */
public class SortedArrayToBST {
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
        int[] nums = new int[]{-10,-3,0,5,9};

        TreeNode root = sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        int half = nums.length / 2;
        TreeNode root = new TreeNode(nums[half]);

        root.left = sortedArrayToBST(nums, 0, half - 1);
        root.right = sortedArrayToBST(nums,half + 1, nums.length - 1);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums, int begin, int to) {
        if (begin > to) {
            return null;
        }
        int half = (begin + to) / 2;
        TreeNode node = new TreeNode(nums[half]);
        node.left = sortedArrayToBST(nums, begin, half - 1);
        node.right = sortedArrayToBST(nums,half + 1, to);
        return node;
    }
}
