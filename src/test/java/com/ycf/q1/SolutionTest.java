package com.ycf.q1;

import com.ycf.q1.Solution;
import org.junit.Test;

public class SolutionTest {
  Solution solution = new Solution();

  @Test
  public void test() {
    int[] nums = new int[] {2,7,11,15};
    int target = 9;
    int[] ints = solution.twoSum(nums, target);
    print(ints);
  }

  public void print(int[] result) {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < result.length; i++) {
      sb.append(i);
      sb.append(",");
    }
    sb.replace(sb.length() - 1, sb.length(), "]");
    System.out.println(sb);
  }
}