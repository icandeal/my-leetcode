package com.ycf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yuchunfan on 2021/11/14
 */

class MapSum {
  Map<String, Integer> map;

  public MapSum() {
    map = new HashMap<>();
  }

  public void insert(String key, int val) {
    map.put(key, val);
  }

  public int sum(String prefix) {
    AtomicInteger sum = new AtomicInteger(0);
    map.entrySet().forEach(x -> {
      if (x.getKey().startsWith(prefix))
        sum.addAndGet(x.getValue());
    });
    return sum.get();
  }
}

