package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Solution867 {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
