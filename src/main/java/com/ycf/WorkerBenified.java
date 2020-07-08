package com.ycf;

import org.junit.Test;

import java.awt.*;
import java.util.*;

/**
 * Created by yuchunfan on 2020/6/28.
 *
 * LeetCode 826. 安排工作以达到最大收益
 * 难度 中等
 */
public class WorkerBenified {
    
    @Test
    public void test() {
        int[] difficulty = new int[]{68,35,52,47,86};
        int[] profit = new int[]{67,17,1,81,3};
        int[] worker = new int[]{92,10,85,84,82};

        System.out.println(maxProfitAssignment(difficulty, profit, worker));

    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Point[] points = new Point[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            points[i] = new Point(difficulty[i], profit[i]);
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a.y));
        Arrays.sort(worker);

        int sum = 0;
        for (int w: worker) {
            for (int i = points.length -1; i >=0; i --) {
                if (points[i].x <= w) {
                    sum += points[i].y;
                    break;
                }
            }
        }

        return sum;
    }

    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        Point[] points = new Point[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            points[i] = new Point(difficulty[i], profit[i]);
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a.y));
        Arrays.sort(worker);

        int sum = 0;
        for (int w: worker) {
            for (int i = points.length -1; i >=0; i --) {
                if (points[i].x <= w) {
                    sum += points[i].y;
                    break;
                }
            }
        }

        return sum;
    }
}
