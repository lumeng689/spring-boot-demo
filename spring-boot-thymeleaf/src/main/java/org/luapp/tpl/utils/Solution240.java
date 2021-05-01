package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution240 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int j = n - 1, i = 0;

        while (j >= 0 && i < m) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                new int[]{1, 4, 7, 11, 15},
//                new int[]{2, 5, 8, 12, 19},
//                new int[]{3, 6, 9, 16, 22},
//                new int[]{10, 13, 14, 17, 24},
//                new int[]{18, 21, 23, 26, 30}
//        };
//
//        System.out.println(searchMatrix(matrix, 5));

        int[][] matrix = new int[][]{
                new int[]{-1, 3}
        };

        System.out.println(searchMatrix(matrix, 3));
    }
}
