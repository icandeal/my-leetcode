package com.ycf.q125;

import java.util.Locale;

/**
 * @author yuchunfan
 * @since 2024/3/14
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("true >> " + solution.isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println("false >> " + solution.isPalindrome("race a car"));
    System.out.println("false >> " + solution.isPalindrome("0P"));
  }

  public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    char[] chars = s.toLowerCase().toCharArray();
    while (left < right) {
      char aChar = chars[left];
      while (true) {
        if (isNumOrChar(aChar)) {
          break;
        }
        left++;
        if (left > right || left > chars.length - 1) {
          break;
        }
        aChar = chars[left];
      }
      char bChar = chars[right];
      while (true) {
        if (isNumOrChar(bChar)) {
          break;
        }
        right --;
        if (left > right || right < 0) {
          break;
        }
        bChar = chars[right];
      }
      if (aChar != bChar) {
        return false;
      }
      left ++;
      right --;
    }
    return true;
  }

  public boolean isNumOrChar(char c) {
    return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }
}
