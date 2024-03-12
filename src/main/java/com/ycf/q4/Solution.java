package com.ycf.q4;

/**
 * Created by yuchunfan on 2021/11/15
 */

public class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int size = nums1.length + nums2.length;
    int right = size / 2;
    int left = size % 2 != 0? right: right - 1;
    int leftVal = 0, rightVal = 0;
    int a = 0, b = 0;
    int v1 = nums1.length < 1? Integer.MAX_VALUE: nums1[0];
    int v2 = nums2.length < 1? Integer.MAX_VALUE: nums2[0];
    for (int i = 0; i <= right; i++) {
      if (v1 <= v2) {
        if (i == left) leftVal = v1;
        if (i == right) rightVal = v1;
        if (a < nums1.length - 1)
          v1 = nums1[++a];
        else {
          v1 = Integer.MAX_VALUE;
        }
      } else {
        if (i == left) leftVal = v2;
        if (i == right) rightVal = v2;
        if (b < nums2.length-1)
          v2 = nums2[++b];
        else {
          v2 = Integer.MAX_VALUE;
        }
      }
    }
    return (leftVal + rightVal) / 2.0;
  }

}
