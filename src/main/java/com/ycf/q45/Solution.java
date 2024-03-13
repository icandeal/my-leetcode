package com.ycf.q45;

/**
 * Created by yuchunfan on 2024/3/12
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.jump(new int[] {2,3,1,1,4}));
    System.out.println(solution.jump(new int[] {2,3,0,1,4}));
    System.out.println(solution.jump(new int[] {2,3,1}));
    System.out.println(solution.jump(new int[] {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3})); // 2
  }

  public int jump(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    return jumpFrom(nums, 0);
  }

  public int jumpFrom(int[] nums, int from) {
    int num = nums[from];
    if (from + num >= nums.length - 1) {
      return 1;
    }
    int offset = 0, max = 0;
    for (int i = 1; i <= num; i++) {
      int newIdx = from + i;
      int r = nums[newIdx];
      if (r >= max - (i - offset)) {
        offset = i;
        max = r;
      }
    }
    return 1 + jumpFrom(nums, from + offset);
  }
}
