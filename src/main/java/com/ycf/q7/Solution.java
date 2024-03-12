package com.ycf.q7;

/**
 * @author yuchunfan
 * @since 2021/11/29
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
  public int reverse(int x) {
    int rest = x, a = 0, b = 0;
    while (rest != 0) {
      b = rest % 10;
      rest = rest / 10;
      if ((a > 0 && Integer.MAX_VALUE - a < b) || (a < 0 && Integer.MIN_VALUE - a > b))
        return 0;
      a = a * 10 + b;
    }
    return a;
  }
}
