package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer004 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length <= 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(arr, 5));

        System.out.println(findNumberIn2DArray(arr, 20));
    }
}
