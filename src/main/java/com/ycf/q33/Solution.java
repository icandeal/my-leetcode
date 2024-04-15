package com.ycf.q33;

import com.ycf.LeetcodeUtils;

/**
 * @author yuchunfan
 * @since 2024/4/15
 *
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual(4, solution.search(LeetcodeUtils.parseIntArray("[4,5,6,7,0,1,2]"), 0));
    LeetcodeUtils.testEqual(-1, solution.search(LeetcodeUtils.parseIntArray("[4,5,6,7,0,1,2]"), 3));
    LeetcodeUtils.testEqual(-1, solution.search(LeetcodeUtils.parseIntArray("[1]"), 0));
  }

  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
  }

  public int search(int[] nums, int target, int left, int right) {
    if (left > right || (nums[left] < nums[right] && (target > nums[right] || target < nums[left]))) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (nums[mid] == target) {
      return mid;
    } else {
      return Math.max(search(nums, target, left, mid - 1), search(nums, target, mid + 1, right));
    }
  }
}