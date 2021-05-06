package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/05
 **/
public class Solution200 {

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        int[] direction = new int[]{-1, 0, 1, 0, -1};

        for (int i = 0; i < direction.length - 1; i++) {
            int x = row + direction[i];
            int y = col + direction[i + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                dfs(grid, x, y);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        }));

        System.out.println(numIslands(new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
        }));
    }
}
