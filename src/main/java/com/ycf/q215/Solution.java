package com.ycf.q215;

import java.util.Arrays;

/**
 * @author yuchunfan
 * @since 2024/12/2
 */
public class Solution {
  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k - 1];
  }
}
