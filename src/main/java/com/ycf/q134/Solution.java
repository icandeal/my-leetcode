package com.ycf.q134;

/**
 * Created by yuchunfan on 2024/3/13
 */

public class Solution {
  public static void main(String[] args) {
    int[] gas = new int[] {1,2,3,4,5}, cost = new int[] {3,4,5,1,2};
    Solution solution = new Solution();
    System.out.println(">>> 3 : "+solution.canCompleteCircuit(gas, cost));

    gas = new int[]{2,3,4};
    cost = new int[]{3,4,3};
    System.out.println(">>> -1 : "+solution.canCompleteCircuit(gas, cost));
  }

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int length = gas.length;
    int[] allLeft = new int[length];
    int sum = 0, left = 0, start = 0;
    for (int i = 0; i < length; i++) {
      int i1 = gas[i] - cost[i];
      allLeft[i] = i1;
      sum += i1;
      if (left < 0 && i1 > 0) {
        left = i1;
        start = i;
      } else {
        left += i1;
      }
    }

    if (sum < 0) {
      return -1;
    }

    return start;
  }
}
