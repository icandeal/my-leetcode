package com.ycf.q77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuchunfan
 * @since 2024/12/7
 */
public class Solution {
  
  List<List<Integer>> result = new LinkedList<>();
  List<Integer> list = new ArrayList<>();
  public List<List<Integer>> combine(int n, int k) {
    combine(n, 1, k);
    return result;
  }

  public void combine(int n, int from, int k) {
    if (list.size() == k) {
      result.add(new ArrayList<>(list));
    }

    for (int i = from; i <= n; i++) {
      list.add(i);
      combine(n, i + 1, k);
      list.remove(list.size() - 1);
    }
  }
}
