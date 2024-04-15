package com.ycf.q162;

import com.ycf.LeetcodeUtils;

/**
 * @author yuchunfan
 * @since 2024/4/14
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual(2, solution.findPeakElement(LeetcodeUtils.parseIntArray("[1,2,3,1]")));
  }

  public int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        if (nums[i] > nums[i + 1]) {
          return 0;
        }
      } else if (i == nums.length - 1) {
        if (nums[i] > nums[i - 1]) {
          return nums.length - 1;
        }
      } else if ((nums[i] > nums[i - 1] && nums[i] > nums[i + 1])) {
        return i;
      }
    }
    return 0;
  }
}
