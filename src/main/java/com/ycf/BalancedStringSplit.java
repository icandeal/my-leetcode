package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/6/29.
 *
 * Leetcode 1221. 分割平衡字符串
 * 难度 简单
 */
public class BalancedStringSplit {

    @Test
    public void test(String[] args) {
        String s = "LLLLRRRR";
        System.out.println(balancedStringSplit(s));
    }

    public int balancedStringSplit(String s) {
        int begin = 0, cnt1 = 0, cnt2 = 0, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(begin) && cnt2 == 0) {
                cnt1 ++;
            } else if (s.charAt(i) != s.charAt(begin) && cnt2 < cnt1){
                cnt2 ++;
            } else {
                cnt ++;
                System.out.println("begin = "+ begin + " end = "+ i+ " str = " + s.substring(begin, i));
                cnt1 = 1;
                cnt2 = 0;
                begin = i;
            }
        }
        if (cnt2 > 0) {
            cnt ++;
            System.out.println("begin = "+ begin + " end = "+ s.length()+ " str = " + s.substring(begin));
        }
        return cnt;
    }
}
