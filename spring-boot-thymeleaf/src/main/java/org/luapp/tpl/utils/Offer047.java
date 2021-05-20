package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer047 {

    //
    // 多开了一行的空间，避免讨论i=0 j=0的情况了
    //
    public static int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }

    public static int maxValue1(int[][] grid) {

        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] gain = new int[m][n];

        gain[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            gain[0][i] = gain[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            gain[i][0] = gain[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                gain[i][j] = Math.max(gain[i - 1][j], gain[i][j - 1]) + grid[i][j];
            }
        }

        return gain[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        }));
    }
}
