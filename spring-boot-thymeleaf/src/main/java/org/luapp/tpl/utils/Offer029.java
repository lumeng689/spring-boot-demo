package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer029 {

    public static int[] spiralOrder(int[][] matrix) {
        int i = 0;
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        int[] path = new int[(rows+1) * (cols+1)];
        int count = 0;

        while (2 * i < rows && 2 * i < cols) {
            int endRow = rows - i;
            int endCol = cols - i;
            // 从左到右
            for (int j = i; j <= endCol; j++) {
                path[count++] = matrix[i][j];
            }

            for (int j = i+1;j <= endRow;j++) {
                path[count++] = matrix[j][endCol];
            }

            for (int j = endCol-1;j >=i;j--) {
                path[count++] = matrix[endRow][j];
            }

            for (int j = endRow-1;j>i;j--) {
                path[count++] = matrix[j][i];
            }
            i++;
            // 从上到下
            // 从右到左
            // 从下到上
        }

        return path;
    }

    public static void main(String[] args) {
        Util.printArray(spiralOrder(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }));

        Util.printArray(spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}
        }));
    }
}
