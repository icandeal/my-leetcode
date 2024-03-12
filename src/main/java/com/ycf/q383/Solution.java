package com.ycf.q383;

/**
 * Created by yuchunfan on 2024/3/10
 */

public class Solution {
  public static void main(String[] args) {
    String ransomNote = "aa", magazine = "ab";
    Solution solution = new Solution();
    System.out.println(solution.canConstruct(ransomNote, magazine));
  }

  public boolean canConstruct(String ransomNote, String magazine) {
    char[] chars = magazine.toCharArray();
    int[] charMap = new int[26];
    for (int i = 0; i < chars.length; i++) {
      char aChar = chars[i];
      charMap[aChar - 'a'] ++;
    }

    char[] array = ransomNote.toCharArray();
    for (int i = 0; i < array.length; i++) {
      char c = array[i];
      int i1 = c - 'a';
      charMap[i1] --;
      if (charMap[i1] < 0) return false;
    }
    return true;
  }
}
