package com.ycf;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,4},{3,6},{1,8}};
        System.out.println(removeCoveredIntervals(intervals));
    }

//    public static int removeCoveredIntervals(int[][] intervals) {
//        List<Point> list = new ArrayList<>();
//        for (int[] tuple: intervals) {
//            list.add(new Point(tuple[0],tuple[1]));
//        }
//        list.sort((a,b) -> {
//            if (a.x < b.x)
//                return -1;
//            else if (a.x == b.x && a.y > b.y)
//                return -1;
//            else
//                return 1;
//        });
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(i).y >= list.get(j).y) {
//                    list.remove(j--);
//                }
//            }
//        }
//        return list.size();
//    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]? o2[1] - o1[1]: o1[0] - o2[0];
            }
        });

        int count = 0;
        int end, prev_end = 0;
        for (int[] curr : intervals) {
            end = curr[1];
            // if current interval is not covered
            // by the previous one
            if (prev_end < end) {
                ++count;
                prev_end = end;
            }
        }
        return count;
    }
}
