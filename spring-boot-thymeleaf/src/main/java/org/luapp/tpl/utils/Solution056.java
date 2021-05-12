package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.function.IntFunction;

/**
 * @author: 86150
 * @create: 2021/05/11
 **/
public class Solution056 {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Deque<int[]> stack = new ArrayDeque<>();

        int i = 0;

        while (i < intervals.length) {
            if (stack.isEmpty()) {
                stack.push(intervals[i]);
            } else {
                int[] elem = stack.peek();
                if (elem[1] >= intervals[i][0]) {
                    stack.pop();
                    stack.push(new int[]{elem[0], Math.max(intervals[i][1],elem[1])});
                } else {
                    stack.push(intervals[i]);
                }
            }
            i++;
        }

        int[][] ans = new int[stack.size()][];

        for(int j =0;j < ans.length;j++) {
            ans[j] = stack.pollLast();
        }

        return ans;
    }

    public static void main(String[] args) {
        Util.printMatrix(merge(new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        }));

        Util.printMatrix(merge(new int[][]{
                new int[]{1, 4},
                new int[]{4, 5},
        }));
    }
}
