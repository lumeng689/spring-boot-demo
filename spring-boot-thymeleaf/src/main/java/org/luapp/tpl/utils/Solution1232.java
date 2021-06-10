package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/10
 **/
public class Solution1232 {

    public static boolean checkStraightLine(int[][] coordinates) {

        if (coordinates == null || coordinates.length <= 2) {
            return true;
        }

        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            int x1 = coordinates[i - 1][0];
            int y1 = coordinates[i - 1][1];

            int x2 = coordinates[i - 2][0];
            int y2 = coordinates[i - 2][1];

            if (x1 == x && x2 == x || y1 == y && y2 == y) {
                continue;
            }

            if (x2 - x1 == 0 || y2 - y1 == 0) {
                return false;
            }

            double left = (x - x1) * 1.0 / (x2 - x1);
            double right = (y - y1) * 1.0 / (y2 - y1);

            if (left != right) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkStraightLineStandard(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
                new int[]{4, 5},
                new int[]{5, 6},
                new int[]{6, 7}
        }));
        System.out.println(checkStraightLine(new int[][]{
                new int[]{1, 1},
                new int[]{2, 2},
                new int[]{3, 4},
                new int[]{4, 5},
                new int[]{5, 6},
                new int[]{7, 7}
        }));

        System.out.println(checkStraightLine(new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{0, -1}
        }));

        System.out.println(checkStraightLine(new int[][]{
                new int[]{0, 1},
                new int[]{1, 1},
                new int[]{-1, 1}
        }));
    }
}
