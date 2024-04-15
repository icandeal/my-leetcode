package com.ycf.q128;

import com.ycf.LeetcodeUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yuchunfan
 * @since 2024/4/2
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    LeetcodeUtils.testEqual(4, solution.longestConsecutive(LeetcodeUtils.parseIntArray("[100,4,200,1,3,2]")));
  }

  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }

    int max = 0;
    for (Integer val : set) {
      int cnt = 1;
      if (set.contains(val - 1)) {
        continue;
      }
      int s = val;
      while (set.contains(++s)) {
        cnt++;
      }
      max = Math.max(cnt, max);
    }
    return max;
  }

}
