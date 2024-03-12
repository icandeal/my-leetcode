package com.ycf.q26;

/**
 * Created by yuchunfan on 2024/3/11
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

    int len = solution.removeDuplicates(nums);
    System.out.println(len);
    for (int i = 0; i < len; i++) {
      System.out.print(nums[i] + ",");
    }
  }

  public int removeDuplicates(int[] nums) {
    int left = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[left] != nums[i]) {
        nums[++ left] = nums[i];
      }
    }
    return left + 1;
  }
}
