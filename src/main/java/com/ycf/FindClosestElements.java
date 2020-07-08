package com.ycf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuchunfan on 2020/6/29.
 *
 * Leetcode 658. 找到 K 个最接近的元素
 * 难度 中等
 */
public class FindClosestElements {
    @Test
    public void test() {
        int[] arr = new int[]{1,2,3,4,5,9,10,11,12,13,14,15,17};
        int k = 2, x = -1;
        System.out.println("bcs = "+arr[binaryCloseSearch(arr, 5, 0, arr.length -1)]);
        for (Integer i: findClosestElements(arr, k, x)) {
            System.out.println(i);
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int idx = binaryCloseSearch(arr, x, 0, arr.length -1);
        int end = idx;
        for (int i = 1; i < k; i++) {
            if (idx - 1 < 0) {
                end ++;
            } else if (end + 1 >= arr.length) {
                idx --;
            } else if (x - arr[idx - 1] <= arr[end + 1] - x) {
                idx --;
            } else {
                end ++;
            }
        }
        int[] r = Arrays.copyOfRange(arr, idx, end + 1);
        for (int i: r){
            res.add(i);
        }
        return res;
    }

    public int binaryCloseSearch(int[] arr, int target, int begin, int end) {
        if (begin > end) {
            if (end < 0)
                return 0;
            else if (begin > arr.length -1)
                return arr.length -1;
            else
                return target - arr[end] > arr[begin] - target ? begin : end;
        }
        if (arr.length < 1) {
            return -1;
        }
        int half = (begin + end) / 2;
        if (arr[half] == target) {
            return half;
        } else if (arr[half] > target) {
            return binaryCloseSearch(arr, target, begin, half - 1);
        } else {
            return binaryCloseSearch(arr, target, half + 1, end);
        }
    }
}
