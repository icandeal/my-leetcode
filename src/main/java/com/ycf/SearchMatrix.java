package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/6/29.
 *
 * LeetCode 74. 搜索二维矩阵
 * 难度 中等
 */
public class SearchMatrix {

    @Test
    public void test() {
        int[][] matrix = new int[][]{{}} ;
        System.out.println(searchMatrix(matrix, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (matrix[i].length < 1)
                return false;
            if (matrix[i][0] <= target) {
                if (matrix[i][0] == target)
                    return true;
                return binarySearch(matrix[i], target, 0, matrix[i].length - 1);
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return false;
        }
        int half = (begin + end) / 2;

        if (target == nums[half]) {
            return true;
        } else if (target > nums[half]) {
            return binarySearch(nums, target, half + 1, end);
        } else {
            return binarySearch(nums, target, begin, half -1);
        }
    }
}
