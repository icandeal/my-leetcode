package com.ycf.q1206;

import java.util.Random;

/**
 * @author yuchunfan
 * @since 2024/4/12
 */

public class Skiplist {

  Random random = new Random();
  int p = 2;
  int maxLevel = 32;
  int currentLevel = 0;
  SkipNode root = new SkipNode(maxLevel);

  public int randomLevel() {
    int level = 1;
    while (level < maxLevel && random.nextInt(p) == 0) {
      level ++;
    }
    return level;
  }

  public Skiplist() {

  }

  public boolean search(int target) {
    if (currentLevel == 0) {
      return false;
    }
    SkipNode c = root;
    for (int i = currentLevel - 1; i >= 0; i--) {
      while (c.next[i] != null && c.next[i].val <= target) {
        c = c.next[i];
      }
      if (c.val != null && c.val == target) {
        return true;
      }
    }
    return false;
  }

  public void add(int num) {
    SkipNode c = root;
    SkipNode[] scan = new SkipNode[currentLevel];
    for (int i = currentLevel - 1; i >= 0; i--) {
      while (c.next[i] != null && c.next[i].val <= num) {
        c = c.next[i];
      }
      if (c.val != null && c.val == num) {
        return;
      }
      scan[i] = c;
    }
    int randomLevel = randomLevel();
    SkipNode skipNode = new SkipNode(num, maxLevel);
    if (currentLevel < randomLevel) {
      for (int i = currentLevel; i < randomLevel; i++) {
        root.next[i] = skipNode;
      }
    }
    for (int i = Math.min(randomLevel, currentLevel) - 1; i >= 0; i--) {
      SkipNode tmp = scan[i].next[i];
      skipNode.next[i] = tmp;
      scan[i].next[i] = skipNode;
    }
    currentLevel = Math.max(randomLevel, currentLevel);
    System.out.println(toString());
  }

  public boolean erase(int num) {
    if (currentLevel == 0) {
      return false;
    }
    SkipNode c = root;
    SkipNode[] scan = new SkipNode[currentLevel];
    for (int i = currentLevel - 1; i >= 0; i--) {
      while (c.next[i] != null && c.next[i].val < num) {
        c = c.next[i];
      }
      scan[i] = c;
    }
    boolean doErase = false;
    for (int i = 0; i < currentLevel; i++) {
      if (scan[i].next[i] != null && scan[i].next[i].val == num) {
        doErase = true;
        scan[i].next[i] = scan[i].next[i].next[i];
      }
    }

    System.out.println(toString());
    return doErase;
  }

  public static class SkipNode {
    Integer val;
    SkipNode[] next;

    public SkipNode(int maxLevel) {
      next = new SkipNode[maxLevel];
    }

    public SkipNode(int num, int maxLevel) {
      next = new SkipNode[maxLevel];
      val = num;
    }
  }

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = currentLevel - 1; i >= 0; i--) {
      sb.append("Level ").append(i).append(": ");
      SkipNode s = root.next[i];
      while (s != null) {
        sb.append(s.val).append(" > ");
        s = s.next[i];
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */