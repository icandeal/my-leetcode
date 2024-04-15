package com.ycf.q1206;/**
 * @author yuchunfan
 * @date 2024/4/12
 * @comment
 */

import com.ycf.LeetcodeUtils;
import com.ycf.ResultErrorException;

/**
 *
 *
 * @author yuchunfan
 * @since 2024/4/12
 */

public class Solution {

  public static void main(String[] args) {
    Skiplist skiplist = new Skiplist();
    skiplist.add(1);
    skiplist.add(2);
    skiplist.add(3);
    LeetcodeUtils.testEqual(false, skiplist.search(0));   // 返回 false
    skiplist.add(4);
    LeetcodeUtils.testEqual(true, skiplist.search(1));   // 返回 true
    LeetcodeUtils.testEqual(false, skiplist.erase(0));    // 返回 false，0 不在跳表中
    LeetcodeUtils.testEqual(true, skiplist.erase(1));    // 返回 true
    LeetcodeUtils.testEqual(false, skiplist.search(1));   // 返回 false，1 已被擦除


    String[] strings = LeetcodeUtils.parseStringArray("[\"Skiplist\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"erase\",\"search\",\"add\",\"erase\",\"erase\",\"erase\",\"add\",\"search\",\"search\",\"search\",\"erase\",\"search\",\"add\",\"add\",\"add\",\"erase\",\"search\",\"add\",\"search\",\"erase\",\"search\",\"search\",\"erase\",\"erase\",\"add\",\"erase\",\"search\",\"erase\",\"erase\",\"search\",\"add\",\"add\",\"erase\",\"erase\",\"erase\",\"add\",\"erase\",\"add\",\"erase\",\"erase\",\"add\",\"add\",\"add\",\"search\",\"search\",\"add\",\"erase\",\"search\",\"add\",\"add\",\"search\",\"add\",\"search\",\"erase\",\"erase\",\"search\",\"search\",\"erase\",\"search\",\"add\",\"erase\",\"search\",\"erase\",\"search\",\"erase\",\"erase\",\"search\",\"search\",\"add\",\"add\",\"add\",\"add\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\",\"search\"]");
    int[][] ints = LeetcodeUtils.castIntArrayArray("[[],[16],[5],[14],[13],[0],[3],[12],[9],[12],[3],[6],[7],[0],[1],[10],[5],[12],[7],[16],[7],[0],[9],[16],[3],[2],[17],[2],[17],[0],[9],[14],[1],[6],[1],[16],[9],[10],[9],[2],[3],[16],[15],[12],[7],[4],[3],[2],[1],[14],[13],[12],[3],[6],[17],[2],[3],[14],[11],[0],[13],[2],[1],[10],[17],[0],[5],[8],[9],[8],[11],[10],[11],[10],[9],[8],[15],[14],[1],[6],[17],[16],[13],[4],[5],[4],[17],[16],[7],[14],[1]]");
    String[] array = LeetcodeUtils.parseStringArray("[null,null,null,null,null,null,null,null,null,null,true,false,null,true,false,false,null,true,true,true,true,false,null,null,null,false,false,null,false,false,true,true,false,false,null,true,true,false,true,true,null,null,false,true,false,null,true,null,true,true,null,null,null,false,false,null,true,false,null,null,true,null,false,false,false,true,true,false,true,null,true,false,false,false,true,true,false,false,null,null,null,null,true,true,true,true,true,true,false,false,true]");

    Skiplist list = new Skiplist();
    for (int i = 1; i < array.length; i++) {
      String action = strings[i];
      int[] val = ints[i];
      String result = array[i];
      System.out.println("####### round: " + i + " >> " + action + " : " + val[0]);
      try {
        switch (action) {
          case "add":
            list.add(val[0]);
            break;
          case "search":
            LeetcodeUtils.testEqual(Boolean.parseBoolean(result),list.search(val[0]));
            break;
          case "erase":
            LeetcodeUtils.testEqual(Boolean.parseBoolean(result), list.erase(val[0]));
            break;
        }
      } catch (ResultErrorException e) {
        System.out.println(list.toString());
        throw e;
      }

    }
  }
}
