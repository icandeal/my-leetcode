package com.ycf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuchunfan on 2020/7/9.
 */
public class TrieTree {

    public Node root = new Node();

    public static class Node {
        boolean isEnd = false;
        Map<Character, Node> child = new HashMap<>();

        public Node() {
        }
        public Node(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }

    public void add(String word) {
        int i = word.length() - 1;
        Node tmp = this.root;
        while (i >= 0) {
            if (tmp.child.containsKey(word.charAt(i))) {
                tmp = tmp.child.get(word.charAt(i));
                if (i == 0)
                    tmp.isEnd = true;
            } else {
                Node n = new Node(i == 0? true: false);
                tmp.child.put(word.charAt(i), n);
                tmp = n;
            }
            i--;
        }
    }
}
