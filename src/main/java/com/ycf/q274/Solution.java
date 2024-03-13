package com.ycf.q274;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yuchunfan on 2024/3/12
 */

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println("3 >> " + solution.hIndex(new int[] {3,0,6,1,5}));
    System.out.println("1 >> " + solution.hIndex(new int[] {1,3,1}));

    System.out.println("3 >> " + solution.hIndex(new int[] {7,10,10,1,1}));



  }

  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int h = 0;
    for (int i = 0; i < citations.length; i++) {
      int citation = citations[citations.length - i - 1];
      if (citation - i - 1 < 0) {
        break;
      }
      h = i + 1;
    }
    return h;
  }
}
