package com.ycf.q30;

import com.ycf.LeetcodeUtils;

import java.util.*;

/**
 * @author yuchunfan
 * @since 2024/3/14
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "barfoothefoobarman";
    String[] words = new String[] {"foo","bar"};

//    System.out.println(solution.findSubstring(s, words));

    System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"}));
    System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));


  }
  public List<Integer> findSubstring(String s, String[] words) {

    return null;
  }
  public List<Integer> findSubstringTimeout(String s, String[] words) {
    List<Integer> result = new LinkedList<>();
    List<Integer>[] index = new LinkedList[s.length()];
    int wordLen = -1;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (wordLen == -1) {
        wordLen = word.length();
      }
      int from = -1;
      while (true) {
        from = s.indexOf(word, from + 1);
        if (from == -1) {
          break;
        }
        List<Integer> set = index[from];
        if (set == null) {
          index[from] = new LinkedList<>();
        }
        index[from].add(i);
      }
    }

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < s.length() - wordLen * words.length + 1; i++) {
      if (index[i] == null) {
        continue;
      }
      set.clear();
      for (int j = 0; j < words.length; j++) {
        List<Integer> index1 = index[i + j * wordLen];
        if (index1 != null) {
          for (Integer idx: index1) {
            if (!set.contains(idx)) {
              set.add(idx);
              break;
            }
          }
        }
      }
      if (set.size() == words.length) {
        result.add(i);
      }
    }
    return result;
  }
}
