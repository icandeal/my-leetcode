package com.ycf.q1;

/**
 * Created by yuchunfan on 2021/11/14
 */

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    int a, b;
    for (int i = 0; i < nums.length; i++) {
      a = nums[i];
        for (int j = i + 1; j < nums.length; j++) {
          b = nums[j];
          if (a + b == target)
            return new int[] {i, j};
        }
    }
    return null;
  }
}
