package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/1.
 *
 * 插入排序
 */
public class InsertionSort {

    @Test
    public void test() {
        int[] nums = new int[]{3,1,5,7,2,8,19,15};
        insertionSort(nums);
        for (int i: nums) {
            System.out.println(i);
        }
    }

    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1, tmp = nums[i];
            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j --;
            }
            nums[j + 1] = tmp;
        }
    }
}
