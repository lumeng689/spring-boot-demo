package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/08
 **/
public class Solution1252 {

    public static int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            int col = indices[i][1];

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == row) {
                        matrix[j][k]++;
                    }

                    if (k == col) {
                        matrix[j][k]++;
                    }
                }
            }
        }

        int ans = 0;

        for (int i =0;i < m;i++) {
            for (int j =0;j< n;j++) {
                if (matrix[i][j]%2 == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(oddCells(2, 3, new int[][]{
                new int[]{0, 1},
                new int[]{1, 1}
        }));
        System.out.println(oddCells(2, 2, new int[][]{
                new int[]{1, 1},
                new int[]{0, 0}
        }));
    }
}
