package com.ycf.q55;

/**
 * Created by yuchunfan on 2024/3/12
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.canJump(new int[] {2,3,1,1,4}));
    System.out.println(solution.canJump(new int[] {3,2,1,0,4}));
    System.out.println(solution.canJump(new int[] {2,5,0,0}));
    System.out.println(solution.canJump(new int[] {0, 1}));
    System.out.println(solution.canJump(new int[] {0}));
  }
  public boolean canJump(int[] nums) {
    int left = 0;
    for (int i = 0; i < nums.length; i++) {
      left = Math.max(nums[i], left);

      if (left <= 0 && i < nums.length - 1) {
        return false;
      }

      left --;
    }
    return true;
  }

  public boolean canJumpTimeout(int[] nums) {

    return jump(nums, 0);
  }

  public boolean jump(int[] nums, int idx) {
    if (idx >= nums.length - 1) {
      return true;
    }
    int num = nums[idx];
    System.out.println(num);
    for (int i = num; i > 0; i--) {
      if (jump(nums, idx + i)) {
        return true;
      }
    }
    return false;
  }
}
