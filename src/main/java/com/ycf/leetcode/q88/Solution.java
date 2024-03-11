package com.ycf.leetcode.q88;

/**
 * Created by yuchunfan on 2024/3/10
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    solution.merge(nums1, 3, nums2, 3);

    for (int i = 0; i < nums1.length; i++) {
      System.out.println(nums1[i]);
    }
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int a = 0, b = 0;
    for (int i = 0; i < m + n; i++) {
      if (a >= m || b >= n) {
        break;
      }
      if (nums1[a] <= nums2[b]) {
        a ++;
      } else {
        int tmp = nums1[a];
        nums1[a] = nums2[b];
        nums2[b] = tmp;
      }
    }
    if (b < n) {
      for (int i = b; i < n; i++) {
        nums1[m ++] = nums2[i];
      }
    }
  }
}
