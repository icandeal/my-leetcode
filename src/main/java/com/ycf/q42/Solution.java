package com.ycf.q42;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuchunfan on 2024/3/13
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println("6 >>>> " + solution.trapDP(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
  }

  public int trapDP(int[] height) {
    int len = height.length;
    int[] leftMax = new int[len];
    int[] rightMax = new int[len];
    leftMax[0] = height[0];
    rightMax[len - 1] = height[len - 1];
    for (int i = 1; i < len; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
      rightMax[len - i - 1] = Math.max(rightMax[len - i], height[len - i - 1]);
    }

    int sum = 0;
    for (int i = 1; i < len; i++) {
      sum += Math.min(leftMax[i], rightMax[i]) - height[i];
    }
    return sum;
  }

  public int trap(int[] height) {
    int sum = 0, i = 0;
    while (i < height.length - 1) {
      int leftHeight = height[i];
      if (leftHeight > height[i + 1]) {
        int right = i, maxHeight = 0;
        for (int j = i + 2; j < height.length; j++) {
          int rightHeight = height[j];
          if (rightHeight > height[j - 1]) {
            if (rightHeight >= leftHeight) {
              right = j;
              break;
            }
            if (rightHeight > maxHeight) {
              maxHeight = rightHeight;
              right = j;
            }
          }
        }
        if (i == right) {
          return sum;
        }
        sum += doSummary(height, i, right);
        i = right;
      } else {
        i++;
      }
    }
    return sum;
  }

  public int doSummary(int[] height, int left, int right) {
    int sum = 0;
    int h = Math.min(height[right], height[left]);
    if (h < 1) {
      return 0;
    }
    for (int i = left + 1; i < right; i++) {
      int poll = height[i];
      if (poll < h) {
        sum += h - poll;
      }
    }

    return sum;
  }

}
