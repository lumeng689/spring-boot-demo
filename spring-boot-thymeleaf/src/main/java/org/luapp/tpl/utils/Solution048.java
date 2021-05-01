package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution048 {

    public static void rotate(int[][] matrix) {

        int n = matrix.length-1;

        for (int i = 0; i <= n / 2; i++) {
            for (int j = i; j < n - i; j++) {
                int tmp = matrix[j][n-i];
                matrix[j][n-i] = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n-i][n - j];
                matrix[n-i][n - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };
        Util.printMatrix(matrix1);
        rotate(matrix1);
        Util.printMatrix(matrix1);


        int[][] matrix2 = new int[][]{
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16},
        };
        Util.printMatrix(matrix2);
        rotate(matrix2);
        Util.printMatrix(matrix2);

        int[][] matrix3 = new int[][]{
                new int[]{1}
        };
        Util.printMatrix(matrix3);
        rotate(matrix3);
        Util.printMatrix(matrix3);

        int[][] matrix4 = new int[][]{
                new int[]{1, 2},
                new int[]{3, 4}
        };
        Util.printMatrix(matrix4);
        rotate(matrix4);
        Util.printMatrix(matrix4);
    }
}
