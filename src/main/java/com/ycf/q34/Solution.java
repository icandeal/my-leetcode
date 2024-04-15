package com.ycf.q34;

import com.ycf.LeetcodeUtils;

/**
 * @author yuchunfan
 * @since 2024/4/15
 */

public class Solution {

  /**
   *
   * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
   *
   * 如果数组中不存在目标值 target，返回 [-1, -1]。
   *
   * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
   *
   * 示例 1：
   *
   * 输入：nums = [5,7,7,8,8,10], target = 8
   * 输出：[3,4]
   * 示例 2：
   *
   * 输入：nums = [5,7,7,8,8,10], target = 6
   * 输出：[-1,-1]
   * 示例 3：
   *
   * 输入：nums = [], target = 0
   * 输出：[-1,-1]
   * @param args
   */

  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual("[3,4]", LeetcodeUtils.arrayToString(solution.searchRange(LeetcodeUtils.parseIntArray("[5,7,7,8,8,10]"), 8)));
    LeetcodeUtils.testEqual("[-1,-1]", LeetcodeUtils.arrayToString(solution.searchRange(LeetcodeUtils.parseIntArray("[5,7,7,8,8,10]"), 6)));
    LeetcodeUtils.testEqual("[-1,-1]", LeetcodeUtils.arrayToString(solution.searchRange(LeetcodeUtils.parseIntArray("[]"), 0)));
  }

  public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};
    if (nums.length == 0) {
      return result;
    }
    binarySearch(nums, target, result, 0, nums.length - 1);
    return result;
  }

  public void binarySearch(int[] nums, int target, int[] result, int left, int right) {
    if (left > right || left < 0 || right >= nums.length) {
      return;
    }

    int mid = (left + right) / 2;

    int num = nums[mid];
    if (num == target) {
      if (result[0] == -1 || result[0] > mid) {
        result[0] = mid;
      }
      if (result[1] == -1 || result[1] < mid) {
        result[1] = mid;
      }
      binarySearch(nums, target, result, left, mid - 1);
      binarySearch(nums, target, result, mid + 1, right);
    } else if (num < target) {
      binarySearch(nums, target, result, mid + 1, right);
    } else {
      binarySearch(nums, target, result, left, mid - 1);
    }
  }
}
