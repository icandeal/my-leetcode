package com.ycf;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) {
        for (String s: generateParenthesis(3)) {
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        int left = 0, right = 0;
        List<String> results = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Stack<Point> lrs = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0 || sb.length() < 2 * n) {
            if (left < n) {
                if (left > right) {
                    stack.add(sb.toString());
                    lrs.add(new Point(left, right));
                }
                sb.append("(");
                left ++;
            } else if (right < left){
                right ++;
                sb.append(")");
            } else {
                results.add(sb.toString());
                sb = new StringBuilder(stack.pop());
                Point p = lrs.pop();
                left = p.x;
                right = p.y;
                right++;
                sb.append(")");
            }
        }
        results.add(sb.toString());
        return results;
    }
}
