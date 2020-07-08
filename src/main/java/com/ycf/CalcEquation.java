package com.ycf;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuchunfan on 2020/7/3.
 *
 * LeetCode 399. 除法求值
 * 难度：中等
 * 考点：并查集
 */
public class CalcEquation {

    @Test
    public void test() {
        List<List<String>> euqations = new ArrayList<>();
        euqations.add(Arrays.asList("a", "b"));
        euqations.add(Arrays.asList("b", "c"));

        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "a"));

        calcEquation(euqations, values, queries);
    }

    private Map<String, String> parentsMap = new HashMap<>();
    private Map<String, Double> valuesMap = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            union(list.get(0), list.get(1), values[i]);
        }

        int idx = 0;
        for (List<String> q: queries) {
            String parent = q.get(0);
            String child = q.get(1);

            String rp = root(parent);
            String rc = root(child);

            if (rp == null || rc == null || !rp.equals(rc)) {
                res[idx++] = -1;
            } else {
                res[idx++] = cal(child) / cal(parent);
            }
        }

        return res;
    }

    public void init(String node) {
        if (!parentsMap.containsKey(node)) {
            parentsMap.put(node, node);
            valuesMap.put(node, 1.0);
        }
    }

    public String root(String node) {
        if (!parentsMap.containsKey(node))
            return null;
        while (!parentsMap.get(node).equals(node)) {
            node = parentsMap.get(node);
        }
        return node;
    }
    public double cal(String node) {
        double multiply = 1.0;
        while (!parentsMap.get(node).equals(node)) {
            multiply *= valuesMap.get(node);
            node = parentsMap.get(node);
        }
        return multiply;
    }
    public void union(String parent, String child, double value) {
        init(parent);
        init(child);

        String rp = root(parent);
        String rc = root(child);

        if (!rp.equals(rc)) {
            parentsMap.put(rc, rp);
            valuesMap.put(rc, value * (cal(parent) / cal(child)));
        }
    }
}
