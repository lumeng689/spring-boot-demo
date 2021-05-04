package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/02
 **/
public class Solution064 {

    public static int minPathSum(int[][] grid) {

        if (grid == null || grid.length <= 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] val = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    val[i][j] = grid[i][j];
                } else if (i == 0) {
                    val[i][j] = val[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    val[i][j] = val[i - 1][j] + grid[i][j];
                } else {
                    val[i][j] = Math.min(val[i - 1][j] + grid[i][j], val[i][j - 1] + grid[i][j]);
                }
            }
        }
        return val[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1},
        }));

        System.out.println(minPathSum(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
        }));
    }
}
