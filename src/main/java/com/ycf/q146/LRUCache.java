package com.ycf.q146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuchunfan
 * @since 2024/12/3
 */
public class LRUCache {

  int capacity;
  Map<Integer, CacheNode> nodeMap;
  CacheNode head;
  CacheNode tail;
  static class CacheNode {
    Integer key;
    Integer value;
    CacheNode pre;
    CacheNode next;
    public CacheNode() {};
    public CacheNode(Integer key, Integer value) {
      this.key = key;
      this.value = value;
    }
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
    nodeMap = new HashMap<>();
    head = new CacheNode(null, -1111);
    tail = new CacheNode(null, -8888);
    head.next = tail;
    tail.pre = head;
  }

  public int get(int key) {
    if (!nodeMap.containsKey(key)) {
      return -1;
    }

    CacheNode node = nodeMap.get(key);
    moveToHead(node);
    System.out.println(this);
    return node.value;
  }

  public void moveToHead(CacheNode node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;
    CacheNode headNext = head.next;
    head.next = node;
    node.pre = head;
    node.next = headNext;
    headNext.pre = node;
  }

  public void addToHead(CacheNode node) {
    node.next = head.next;
    node.next.pre = node;
    head.next = node;
    node.pre = head;
  }

  public void removeTail() {
    CacheNode pre = tail.pre;
    nodeMap.remove(pre.key);
    pre.pre.next = tail;
    tail.pre = pre.pre;
  }

  public void put(int key, int value) {
    CacheNode node = nodeMap.getOrDefault(key, new CacheNode(key, value));
    if (nodeMap.containsKey(key)) {
      node.value = value;
      moveToHead(node);
    } else {
      addToHead(node);
      nodeMap.put(key, node);
      if (nodeMap.size() > capacity) {
        removeTail();
      }
    }
    System.out.println(this);
  }

  public String toString() {
    CacheNode node = head.next;
    StringBuilder sb = new StringBuilder("Cache{");
    while (node != null) {
      sb.append(node.key).append("=").append(node.value).append(",");
      node = node.next;
    }
    if (sb.charAt(sb.length() - 1) == ',') {
      sb.deleteCharAt(sb.length() - 1);
    }
    sb.append("}");
    return sb.toString();
  }
}
