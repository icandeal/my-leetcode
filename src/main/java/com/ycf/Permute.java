package com.ycf;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        for (List<Integer> list: permute(nums)) {
            for (Integer i: list) {
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] tmp = new int[nums.length];
        permute(nums, new ArrayList<>(), tmp, res);
        return res;
    }
    public static void permute(int[] nums, List<Integer> list, int[] tmp, List<List<Integer>> res) {
        if (list.size() >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmp[i] == 1)
                continue;
            tmp[i] = 1;
            list.add(nums[i]);
            permute(nums, list, tmp, res);
            tmp[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
