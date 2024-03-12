package com.ycf.q27;

/**
 * Created by yuchunfan on 2024/3/11
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = new int[] {0,1,2,2,3,0,4,2};
    int val = 2;

    System.out.println(solution.removeElement(nums, val));
  }

  public int removeElement(int[] nums, int val) {
    int left = 0, right = nums.length;
    while (left < right) {
      if (nums[right - 1] == val) {
        right --;
        continue;
      }
      if (nums[left] == val) {
        nums[left ++] = nums[--right];
        nums[right] = val;
      } else {
        left ++;
      }
    }
    return right;
  }
}
