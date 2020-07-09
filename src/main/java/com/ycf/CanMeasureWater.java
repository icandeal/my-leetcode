package com.ycf;

import org.junit.Test;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by yuchunfan on 2020/7/8.
 *
 * LeetCode 365. 水壶问题
 * 穷举递归
 */
public class CanMeasureWater {

    @Test
    public void test() {
        System.out.println(canMeasureWater(3,5,4));
    }

    public boolean canMeasureWater(int x, int y, int z) {
        Stack<Point> stack = new Stack<>();
        stack.add(new Point(0,0));
        Set<Point> set = new HashSet<>();
        while (stack.size() > 0) {
            Point point = stack.pop();
            int remainX = point.x;
            int remainY = point.y;

            if (set.contains(point))
                continue;
            set.add(point);
            if (remainX == z || remainY == z || remainX + remainY == z)
                return true;

            // 倒满x
            stack.add(new Point(x, remainY));
            // 倒满y
            stack.add(new Point(remainX, y));
            // 倒空x
            stack.add(new Point(0, remainY));
            // 倒空y
            stack.add(new Point(remainX, 0));
            // 将x倒入y
            stack.add(new Point(
                remainX > y - remainY ? remainX - y + remainY: 0,
                remainX > y - remainY ? y: remainX + remainY
            ));
            // 将y倒入x
            stack.add(new Point(
                remainY > x - remainX ? x: remainY + remainX,
                remainY > x - remainX ? remainY - x + remainX: 0
            ));
        }
        return false;
    }
}
