package com.ycf.q6;

/**
 * Created by yuchunfan on 2021/11/17
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
  public String convert(String s, int numRows) {
    StringBuilder[] builders = new StringBuilder[numRows];
    boolean isEnd = false;
    while (!isEnd) {
      for (int j = 0; j < numRows; j++) {
        if (s.length() < 1) {
          isEnd = true;
          break;
        }
        StringBuilder builder = builders[j];
        if (builder == null) {
          builder = new StringBuilder();
          builders[j] = builder;
        }
        builder.append(s.charAt(0));
        s = s.substring(1);
      }
      for (int j = numRows - 2; j > 0; j--) {
        if (s.length() < 1) {
          isEnd = true;
          break;
        }
        StringBuilder builder = builders[j];
        builder.append(s.charAt(0));
        s = s.substring(1);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      StringBuilder builder = builders[i];
      if (builder != null)
        sb.append(builder);
    }
    return sb.toString();
  }
}
