package com.ycf.q4;

import com.ycf.q4.Solution;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

  Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test() {
    int[] int1 = {1, 3, 4};
    int[] int2 = {2};

    double medianSortedArrays = solution.findMedianSortedArrays(int1, int2);
    System.out.println(medianSortedArrays);
  }
}