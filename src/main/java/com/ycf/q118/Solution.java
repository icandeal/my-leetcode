package com.ycf.q118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuchunfan
 * @since 2024/3/8
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.generate(5));
  }

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<>();
      List<Integer> preRow = i < 1 ? null : res.get(i - 1);
      for (int j = 0; j < i + 1; j++) {
        if (preRow == null) {
          row.add(1);
        } else {
          row.add((j - 1 < 0 ? 0 : preRow.get(j - 1)) + (j > i - 1 ? 0 : preRow.get(j)));
        }
      }
      res.add(row);
    }
    return res;
  }
}
