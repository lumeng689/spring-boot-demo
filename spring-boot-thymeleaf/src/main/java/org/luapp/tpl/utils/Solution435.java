package org.luapp.tpl.utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: 86150
 * @create: 2021/04/30
 **/
public class Solution435 {

    public static int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length <= 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
                new int[]{1, 3}
        }));

        System.out.println(eraseOverlapIntervals(new int[][]{
                new int[]{1, 2},
                new int[]{1, 2},
                new int[]{1, 2},
        }));

    }
}
