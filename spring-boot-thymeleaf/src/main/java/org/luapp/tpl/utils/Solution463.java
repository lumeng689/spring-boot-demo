package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/08/28
 **/
public class Solution463 {
    public static int islandPerimeter(int[][] grid) {
        int p = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    p += 4;

                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        p = p-2;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        p = p-2;
                    }
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 1, 0},
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 0, 0}
        }));

        System.out.println(islandPerimeter(new int[][]{new int[]{1}}));

        System.out.println(islandPerimeter(new int[][]{new int[]{1, 0}}));
    }
}
