package com.ycf.q238;

/**
 * Created by yuchunfan on 2024/3/13
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[] {1,2,3,4};
    int[] result = solution.productExceptSelf(nums);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + ",");
    }
  }

  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] leftRound = new int[len];

    leftRound[0] = 1;
    for (int i = 1; i < len; i++) {
      leftRound[i] = leftRound[i - 1] * nums[i - 1];
    }
    int r = 1;
    for (int i = len - 2; i >= 0; i--) {
      r = r * nums[i + 1];
      leftRound[i] = r * leftRound[i];
    }

    return leftRound;
  }

  public int[] productExceptSelfSpaceOn(int[] nums) {
    int len = nums.length;
    int[] leftRound = new int[len];
    int[] rightRound = new int[len];

    leftRound[0] = 1;
    rightRound[len - 1] = 1;
    for (int i = 1; i < len; i++) {
      leftRound[i] = leftRound[i - 1] * nums[i - 1];
    }
    for (int i = len - 2; i >= 0; i--) {
      rightRound[i] = rightRound[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < len; i++) {
      leftRound[i] = leftRound[i] * rightRound[i];
    }
    return leftRound;
  }
}
