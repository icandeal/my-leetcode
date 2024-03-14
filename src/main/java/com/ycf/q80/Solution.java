package com.ycf.q80;

/**
 * @author yuchunfan
 * @since 2024/3/12
 */

public class Solution {
  public static void main(String[] args) {
    int[] nums = new int[] {0,0,1,1,1,1,2,3,3};
    Solution solution = new Solution();
    int x = solution.removeDuplicates(nums);
    System.out.println(x);

    for (int i = 0; i < x; i++) {
      System.out.print(nums[i] + ",");
    }
  }

  public int removeDuplicates(int[] nums) {
    int cnt = 1, left = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[left] != nums[i]) {
        nums[++left] = nums[i];
        cnt = 1;
      } else if (++cnt <= 2) {
        nums[++left] = nums[i];
      }
    }
    return left + 1;
  }
}
