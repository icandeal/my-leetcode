package com.ycf.q46;

import java.util.*;

/**
 * @author yuchunfan
 * @since 2024/12/7
 */
public class Solution {

  List<List<Integer>> result = new LinkedList<>();
  List<Integer> list = new ArrayList<>();
  //  Set<Integer> indexSet = new HashSet<>();
  boolean[] visited;

  public List<List<Integer>> permute(int[] nums) {
    visited = new boolean[nums.length];
    recall(nums);
    return result;
  }

  public void recall(int[] nums) {
    if (list.size() == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) {
        continue;
      }
      list.add(nums[i]);
      visited[i] = true;
      recall(nums);
      list.remove(list.size() - 1);
      visited[i] = false;
    }
  }
}
