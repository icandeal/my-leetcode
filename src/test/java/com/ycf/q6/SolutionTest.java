package com.ycf.q6;

import com.ycf.q6.Solution;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

  @Test
  public void test() {
    String str = "PAYPALISHIRING";
    Solution solution = new Solution();
    String convert = solution.convert(str, 3);
    assertEquals("PAHNAPLSIIGYIR", convert);
    String convert1 = solution.convert(str, 4);
    assertEquals("PINALSIGYAHRPI", convert1);
    String a = solution.convert("A", 2);
    System.out.println(a);
    assertEquals("A", a);
  }
}