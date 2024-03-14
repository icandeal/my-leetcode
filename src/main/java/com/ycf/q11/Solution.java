package com.ycf.q11;

import com.ycf.LeetcodeUtils;

/**
 * @author yuchunfan
 * @since 2024/3/14
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual(1, solution.maxArea(LeetcodeUtils.parseIntArray("[1,1]")));
    LeetcodeUtils.testEqual(49, solution.maxArea(LeetcodeUtils.parseIntArray("[1,8,6,2,5,4,8,3,7]")));
  }

  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1, max = 0;
    while (left < right) {
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
      if (height[left] > height[right]) {
        right --;
      } else {
        left ++;
      }
    }
    return max;
  }
}
