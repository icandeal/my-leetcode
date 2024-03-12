package com.ycf.q88;

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
    int[] tmp = new int[m];
    for (int i = 0; i < m; i++) {
      tmp[i] = nums1[i];
    }

    int a = 0, b = 0;
    for (int i = 0; i < m + n; i++) {
      if (a >= m) {
        nums1[i] = nums2[b ++];
      } else if (b >= m) {
        nums1[i] = tmp[a ++];
      } else if (tmp[a] > nums2[b]) {
        nums1[i] = nums2[b ++];
      } else {
        nums1[i] = tmp[a ++];
      }
    }
  }
}
