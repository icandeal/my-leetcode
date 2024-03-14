package com.ycf.q167;

import com.ycf.LeetcodeUtils;

/**
 * @author yuchunfan
 * @since 2024/3/14
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("[1,2] >>> " + LeetcodeUtils.arrayToString(solution.twoSum(new int[] {2,7,11,15}, 9)));
    System.out.println("[2,3] >>> " + LeetcodeUtils.arrayToString(solution.twoSum(new int[] {5,25,75}, 100)));

    System.out.println("[1,2] >>> " + LeetcodeUtils.arrayToString(solution.twoSum(new int[] {-1,0}, -1)));

    System.out.println("[1,2] >>> " + LeetcodeUtils.arrayToString(solution.twoSum(new int[] {0,0,3,4}, 0)));
    System.out.println("[4,5] >>> " + LeetcodeUtils.arrayToString(solution.twoSum(new int[] {1,2,3,4,4,9,56,90}, 8)));

  }

  public int[] twoSum(int[] numbers, int target) {
    int mid = target / 2;
    int idx = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > mid) {
        idx = i - 1;
        break;
      } else if (numbers[i] == mid) {
        idx = i;
        break;
      }
    }
    if (target < 0) {
      idx --;
    }
    int left = idx < 0 ? 0 : idx, right = left + 1;
    while (left >= 0 && right < numbers.length) {
      int sum = numbers[left] + numbers[right];
      if (sum > target) {
        left --;
      } else if (sum < target) {
        right ++;
      } else {
        break;
      }
    }
    return new int[] {left + 1, right + 1};
  }
}
