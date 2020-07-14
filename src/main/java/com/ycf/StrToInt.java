package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/9.
 *
 * LeetCode 剑指 Offer 67. 把字符串转换成整数
 * 难度 中等
 */
public class StrToInt {

    @Test
    public void test() {
        System.out.println(strToInt("42"));
        System.out.println(strToInt("   -42"));
        System.out.println(strToInt("4193 with words"));
        System.out.println(strToInt("words and 987"));
        System.out.println(strToInt("-91283472332"));
    }

    public int strToInt(String str) {
        boolean isNeg = false;
        int sum = -1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (sum == -1) {
                if (c == ' ')
                    continue;
                else if (c == '-') {
                    isNeg = true;
                    sum = 0;
                } else if (c == '+') {
                    sum = 0;
                } else if (c >= '0' && c <= '9') {
                    sum = c - '0';
                } else {
                    return 0;
                }
            } else {
                if (c >= '0' && c <= '9') {
                    int add = c - '0';
                    if (Integer.MAX_VALUE / 10> sum
                        || (Integer.MAX_VALUE/10 == sum && Integer.MAX_VALUE % 10 >= add))
                        sum = sum * 10 + add;
                    else
                        return isNeg? Integer.MIN_VALUE: Integer.MAX_VALUE;
                } else {
                    break;
                }
            }
        }
        if (sum == -1)
            sum = 0;
        return isNeg? -sum: sum;
    }
}
