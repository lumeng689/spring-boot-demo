package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/14
 **/
public class Solution5767 {
    public static boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] flags = new boolean[right - left + 1];

        for (int i =0; i < ranges.length;i++) {
            for (int j =ranges[i][0];j <= ranges[i][1];j++) {
                if (j >= left && j <= right) {
                    flags[j-left] = true;
                }
            }
        }

        for (int i =0;i <flags.length;i++) {
            if (!flags[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isCovered(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{5, 6}
        }, 2, 5));

        System.out.println(isCovered(new int[][]{
                new int[]{1, 10},
                new int[]{10, 20}
        }, 21, 21));
    }

}
