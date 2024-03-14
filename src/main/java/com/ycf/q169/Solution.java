package com.ycf.q169;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuchunfan
 * @since 2024/3/12
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[] {3,2,3};
    System.out.println(solution.majorityElement(nums));
  }

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> cntMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int cnt = cntMap.getOrDefault(nums[i], 0) + 1;
      if (cnt > nums.length / 2) {
        return nums[i];
      }
      cntMap.put(nums[i], cnt);
    }
    return -1;
  }

  public int majorityElementRate(int[] nums) {
    int target = nums[0], cnt = 1;
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      cnt += target == num ? 1 : -1;
      if (cnt <= 0) {
        target = num;
        cnt = 1;
      }
    }
    return target;
  }
}
