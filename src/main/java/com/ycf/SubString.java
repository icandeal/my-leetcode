package com.ycf;

public class SubString {
    public static void main(String[] args) {
        String s = "00110011";
        String s1 = "10101";
        String s2 = "10101";
        String s3 = "10101";

        System.out.println(countBinarySubstrings(s));
    }

    public static int countBinarySubstrings(String s) {
        int AC = 0, BC = 0;
        char a = '0';
        int mark = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                a = s.charAt(i);
                AC ++;
                continue;
            }
            if (s.charAt(i) == a) {
                if (BC == 0)
                    AC ++;
                else {
                    AC = BC;
                    BC = 1;
                    a = s.charAt(i - 1);
                    mark ++;
                }
            } else {
                BC ++;
                if (BC <= AC)
                    mark ++;
            }

        }
        return mark;
    }
}
