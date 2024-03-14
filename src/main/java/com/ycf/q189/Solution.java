package com.ycf.q189;

/**
 * @author yuchunfan
 * @since 2024/3/12
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[] {1,2,3,4,5,6,7};
    int k = 3;
    solution.rotate(nums, k);
    for (int num : nums) {
      System.out.print(num + ",");
    }
    System.out.println();


    nums = new int[] {-1,-100,3,99};
    k = 2;
    solution.rotate(nums, k);
    for (int num : nums) {
      System.out.print(num + ",");
    }
    System.out.println();

  }

  public void rotate(int[] nums, int k) {
    int len = nums.length;
    int offset = k % len;
    if (offset == 0) {
      return;
    }

    int idx = 0, start = 0;
    int last = nums[0];
    for (int i = 0; i < len; i++) {
      int next = (idx + offset) % len;
      int tmp = nums[next];
      nums[next] = last;
      last = tmp;
      idx = next;
      if (idx == start) {
        idx ++;
        last = nums[idx];
        start = idx;
      }
    }
  }
}
