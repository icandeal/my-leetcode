package com.ycf;

import org.junit.Test;

/**
 * Created by yuchunfan on 2020/7/1.
 *
 * LeetCode 718. 最长重复子数组
 * 难度 中等
 */
public class FindLength {

    @Test
    public void test() {
        int[] b = new int[]{1,2,3,2,1};
        int[] a = new int[]{3,2,1,4,7};

        System.out.println(findLength(a, b));
    }

    public int findLength(int[] A, int[] B) {
        int max = 0;
        for (int i = 0; i < A.length + B.length - 1; i++) {
            int a = i >= B.length? i - B.length + 1: 0;
            int b = i >= B.length? 0:  B.length - i - 1;
            int offset = A.length - a > B.length - b? B.length - b: A.length - a;
            int cnt = 0;
            for (int j = 0; j < offset; j ++) {
                if (A[a + j] == B[b + j]) {
                    cnt ++;
                }
                else {
                    cnt = 0;
                }
                if (cnt > max)
                    max = cnt;
            }
        }
        return max;
    }

}
