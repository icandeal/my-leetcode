package com.ycf;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuchunfan
 * @since 2024/11/8
 */
public class QueueTest {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    Deque<Integer> queue = list;

    for (int i = 0; i < 5; i++) {
      queue.add(i);
    }

    for (int i = 0; i < 5; i++) {
      System.out.println(queue.poll());
    }

    for (int i = 0; i < 5; i++) {
      queue.push(i);
    }

    for (int i = 0; i < 5; i++) {
      System.out.println(queue.poll());
    }
  }
}
