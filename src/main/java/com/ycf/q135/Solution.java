package com.ycf.q135;

/**
 * Created by yuchunfan on 2024/3/13
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("5 >>> " + solution.candy(new int[] {1,0,2}));
    System.out.println("4 >>> " + solution.candy(new int[] {1,2,2}));
  }

  public int candy(int[] ratings) {
    int length = ratings.length;
    int[] candys = new int[length];
    candys[0] = 1;
    for (int i = 1; i < length; i++) {
      candys[i] = ratings[i - 1] < ratings[i] ? candys[i - 1] + 1 : 1;
    }

    int sum = candys[length - 1];
    for (int i = length - 2; i >= 0; i--) {
      if (ratings[i + 1] < ratings[i]) {
        candys[i] = Math.max(candys[i + 1] + 1, candys[i]);
      }
      sum += candys[i];
    }
    return sum;
  }
}
