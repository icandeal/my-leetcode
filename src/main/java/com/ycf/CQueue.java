package com.ycf;

import java.util.Stack;

/**
 * Created by yuchunfan on 2020/6/30.
 *
 * Leetcode 剑指 Offer 09. 用两个栈实现队列
 * 难度 简单
 */
public class CQueue {
    Stack<Integer> head = new Stack<>();
    Stack<Integer> tail = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        while (!head.isEmpty()) {
            tail.add(head.pop());
        }
        tail.add(value);
    }

    public int deleteHead() {
        while (!tail.isEmpty()) {
            head.add(tail.pop());
        }
        return head.isEmpty()? -1: head.pop();
    }
}
