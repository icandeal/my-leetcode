package com.ycf;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created by yuchunfan on 2020/6/24.
 *
 * LeetCode 43. 字符串相乘
 * 难度 中等
 */
public class StringMultiply {
    
    @Test
    public void test() {
        String num1 = "9133";
        String num2 = "12";

        System.out.println(multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] sum = new int[len1 + len2];

        for (int i = 0; i < len1; i ++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < len2; j ++) {
                int b = num2.charAt(j) - '0';
                int p0 = len1 + len2 - i - j - 2;
                sum[p0] =  a * b + sum[p0];
            }
        }

        StringBuffer sb = new StringBuffer();
        int overHigh = 0;
        for (int i = 0; i < sum.length; i++) {
            int s = sum[i] + overHigh;
            overHigh = s / 10;
            sb.append(s % 10);
        }
        sb = sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }
}
