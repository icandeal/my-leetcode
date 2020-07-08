package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/1.
 *
 * 选择排序
 */
public class SelectionSort {

    @Test
    public void test() {
        int[] nums = new int[]{3,1,5,7,2,8,19,15};
        selectionSort(nums);
        for (int i: nums) {
            System.out.println(i);
        }
    }

    public void selectionSort(int[] nums) {
        int minIdx;
        for (int i = 0; i < nums.length - 1; i++) {
            minIdx = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                int tmp = nums[minIdx];
                nums[minIdx] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
