package com.ycf;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yuchunfan on 2020/7/8.
 *
 * LeetCode 645. 错误的集合
 * 难度 简单
 */
public class FindErrorNums {

    @Test
    public void test() {
        int[] nums = new int[]{1,2,2,4};
//        int[] nums = new int[]{3,2,3,4,6,5};
//        int[] nums = new int[]{2, 2};
//        int[] nums = new int[]{1, 1};
        int[] res = findErrorNums(nums);
        for (int i: res) {
            System.out.println(i);
        }

    }

    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int pre = -1, order = 1;
        for (int i = 0; i < nums.length; i++) {
            if (pre != -1 && pre == nums[i]) {
                res[0] = pre;
            }
            if (res[1] == 0 && nums[i] > order) {
                res[1] = order;
            }
            if (res[1] == 0 && nums[i] < order)
                order --;
            order++;
            pre = nums[i];
        }

        if (res[1] == 0)
            res[1] = order;
        return res;
    }

//    public int[] findErrorNums(int[] nums) {
//        int[] res = new int[2];
//        int cnt;
//        for (int i = 0; i < nums.length; i++) {
//            cnt = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] == i + 1)
//                    cnt++;
//            }
//            if (cnt == 2)
//                res[0] = i + 1;
//            else if (cnt == 0)
//                res[1] = i + 1;
//        }
//        return res;
//    }
}
