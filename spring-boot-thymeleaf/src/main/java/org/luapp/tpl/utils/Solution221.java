package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/02
 **/
public class Solution221 {

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;

        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }

                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        }));

        System.out.println(maximalSquare(new char[][]{
                new char[]{'0', '1'},
                new char[]{'1', '0'}
        }));

        System.out.println(maximalSquare(new char[][]{
                new char[]{'0'},
        }));

        System.out.println(maximalSquare(new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'0', '0', '1', '1', '1'}
        }));
    }
}
