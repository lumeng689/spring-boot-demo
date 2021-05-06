package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/04
 **/
public class Solution079 {

    public static boolean exist(char[][] board, String word) {

        if (board == null || board.length <= 0 || word == null || word.length() <= 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean check(char[][] board, boolean[][] visited, int row, int col, String word, int idx) {
        if (board[row][col] != word.charAt(idx)) {
            return false;
        } else if (idx >= word.length() - 1) {
            return true;
        }

        visited[row][col] = true;
        int[] directions = new int[]{-1, 0, 1, 0, -1};

        boolean success = false;
        for (int k = 0; k < directions.length - 1; k++) {
            int x = row + directions[k];
            int y = col + directions[k + 1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                if (check(board, visited, x, y, word, idx + 1)) {
                    success = true;
                    break;
                }
            }
        }

        visited[row][col] = false;
        return success;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                new char[]{'a', 'b'},
                new char[]{'c', 'd'},
        }, "acdb"));
        System.out.println(exist(new char[][]{
                new char[]{'A'}
        }, "A"));
        System.out.println(exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "ABCCED"));

        System.out.println(exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "SEE"));

        System.out.println(exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "ABCB"));
    }
}
