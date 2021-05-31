package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/28
 **/
public class Solution1779 {

    public static int nearestValidPoint(int x, int y, int[][] points) {

        int minDist = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            if (x1 == x || y1 == y) {
                int dist = Math.abs(x1 - x) + Math.abs(y1 - y);
                if (dist < minDist) {
                    minIdx = i;
                    minDist = dist;
                }
            }
        }

        return minIdx;
    }

    public static void main(String[] args) {
        System.out.println(nearestValidPoint(3, 4, new int[][]{new int[]{1, 2}, new int[]{3, 1}, new int[]{2, 4}, new int[]{2, 3}, new int[]{4, 4}}));
        System.out.println(nearestValidPoint(3, 4, new int[][]{new int[]{3, 4}}));
    }
}
