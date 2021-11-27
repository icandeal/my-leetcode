package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2021/11/14
 */

public class MapSumTest {
  @Test
  public void test() {
    MapSum mapSum = new MapSum();
    mapSum.insert("apple", 3);
    System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
    mapSum.insert("app", 2);
    System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)

  }
}
