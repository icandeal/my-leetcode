package com.ycf;

import org.junit.Test;

import java.util.Map;

/**
 * Created by yuchunfan on 2020/7/9.
 *
 * LeetCode 面试题 17.13. 恢复空格
 * 难度 中等
 * 考点：动态规划，字典树
 */
public class Respace {

    @Test
    public void test() {
//        String[] dictionary = new String[]{
//            "looked","just","like","her","brother"
//        };
//        String sentence = "jesslookedjustliketimherbrother";
//        String[] dictionary = new String[]{
//            "potimzz"
//        };
//        String sentence = "potimzzpotimzz";

//        ["sssjjs","hschjf","hhh","fhjchfcfshhfjhs","sfh","jsf","cjschjfscscscsfjcjfcfcfh","hccccjjfchcffjjshccsjscsc","chcfjcsshjj","jh","h","f","s","jcshs","jfjssjhsscfc"]
//        "sssjjssfshscfjjshsjjsjchffffs"
        String[] dictionary = new String[]{
            "sssjjs",
            "hschjf",
            "hhh",
            "fhjchfcfshhfjhs",
            "sfh",
            "jsf",
            "cjschjfscscscsfjcjfcfcfh",
            "hccccjjfchcffjjshccsjscsc",
            "chcfjcsshjj",
            "jh",
            "h",
            "f",
            "s",
            "jcshs",
            "jfjssjhsscfc"
        };
        String sentence = "sssjjssfshscfjjshsjjsjchffffs";
        System.out.println(respace(dictionary, sentence));
    }

    public int respace(String[] dictionary, String sentence) {
        TrieTree tree = new TrieTree();
        for (String str: dictionary) {
            tree.add(str);
        }

        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;

        for (int i = 0; i < sentence.length(); i++) {
            dp[i + 1] = dp[i] + 1;
            TrieTree.Node node = tree.root;
            for (int j = i; j >= 0; j--) {
                if (!node.child.containsKey(sentence.charAt(j))) {
                    break;
                }
                node = node.child.get(sentence.charAt(j));

                if (node.isEnd) {
                    dp[i + 1] = Math.min(dp[j], dp[i + 1]);
                }
            }
        }
        return dp[sentence.length()];
    }
}
