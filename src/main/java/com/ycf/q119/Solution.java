package com.ycf.q119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuchunfan
 * @since 2024/3/8
 */

public class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < rowIndex + 1; i++) {
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
    return res.get(rowIndex - 1);
  }
}
