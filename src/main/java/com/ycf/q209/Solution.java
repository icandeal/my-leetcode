package com.ycf.q209;

import com.ycf.LeetcodeUtils;

import java.util.Arrays;

/**
 * @author yuchunfan
 * @since 2024/3/14
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual(
        2, solution.minSubArrayLen(7, LeetcodeUtils.parseIntArray("[2,3,1,2,4,3]"))
    );

    LeetcodeUtils.testEqual(
        1, solution.minSubArrayLen(7, LeetcodeUtils.parseIntArray("[1,1,1,1,7]"))
    );
  }

  public int minSubArrayLen(int target, int[] nums) {
    int sum = nums[0], min = Integer.MAX_VALUE;
    int left = 0, right = 0;
    while (left <= nums.length - 1 || right <= nums.length - 1) {
      if (sum >= target) {
        min = Math.min(min, right - left + 1);
        if (left >= right) {
          break;
        }
        sum -= nums[left];
        left += 1;
      } else {
        if (right >= nums.length - 1) {
          break;
        }
        right += 1;
        sum += nums[right];
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  public int minSubArrayLenTimeout1(int target, int[] nums) {
    int len = nums.length;
    int[] result = new int[len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        int idx = j + i;
        if (idx >= len) {
          break;
        }
        result[j] += nums[idx];
        if (result[j] >= target) {
          return i + 1;
        }
      }
    }
    return 0;
  }

  public int minSubArrayLenTimeout2(int target, int[] nums) {
    int min = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = nums[i];
      if (sum >= target) {
        return 1;
      }
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        if (sum >= target) {
          min = min == 0 ? j - i + 1 : Math.min(j - i + 1, min);
        }
      }
    }

    return min;
  }
}
