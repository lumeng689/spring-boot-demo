package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/20
 **/
public class Solution1351 {

    public static int countNegatives(int[][] grid) {
        int ans = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] >= 0) {
                    break;
                } else {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{
                new int[]{4, 3, 2, -1},
                new int[]{3, 2, 1, -1},
                new int[]{1, 1, -1, -2},
                new int[]{-1, -1, -2, -3}
        }));
        System.out.println(countNegatives(new int[][]{
                new int[]{3, 2},
                new int[]{1, 0}
        }));

        System.out.println(countNegatives(new int[][]{
                new int[]{1, -1},
                new int[]{-1, -1}
        }));

        System.out.println(countNegatives(new int[][]{
                new int[]{-1}
        }));
    }
}
