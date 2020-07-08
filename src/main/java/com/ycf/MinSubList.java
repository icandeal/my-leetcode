package com.ycf;

public class MinSubList {
    public static void main(String[] args) {
        int[] nums = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLen(213, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int sum = 0, cnt = 0, begin = 0, min= 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            cnt ++;
            while (sum >= s) {
                if (min == 0 || min > cnt)
                    min = cnt;
                cnt --;
                sum -= nums[begin++];
            }
        }
        return min;
    }
}
