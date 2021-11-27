package com.ycf.leetcode.q318;

/**
 * Created by yuchunfan on 2021/11/17
 *
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
  public int maxProduct(String[] words) {
    int max = 0;
    for (int i = 0; i < words.length; i++) {
      String a = words[i];
      for (int j = i + 1; j < words.length; j++) {
        String b = words[j];
        int len = a.length() * b.length();
        if (len > max) {
          boolean has = false;
          for (int k = 0; k < b.length(); k++) {
            if (a.contains(b.charAt(k) +"")) {
              has = true;
              break;
            }
          }
          if (!has) max = len;
        }
      }
    }
    return max;
  }
}