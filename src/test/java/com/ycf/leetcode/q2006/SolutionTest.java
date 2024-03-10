package com.ycf.leetcode.q2006;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
  Solution solution;
  @Before
  public void setUp() {
    solution = new Solution();
  }

  @Test
  public void name() {
    int[] nums = new int[]{1,2,2,1};
    int i = solution.countKDifference(nums, 1);
    assertEquals(i, 4);
  }
}