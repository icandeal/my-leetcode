package com.ycf.q39;

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
  int sum = 0;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    combinationSum(candidates, 0, target);
    return result;
  }

  public void combinationSum(int[] candidates, int idx, int target) {
    if (sum > target || idx >= candidates.length) {
      return;
    }
    if (sum == target) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = idx; i < candidates.length; i++) {
      int candidate = candidates[i];
      sum += candidate;
      list.add(candidate);
      combinationSum(candidates, i, target);
      sum -= candidate;
      list.remove(list.size() - 1);
    }
  }
}
