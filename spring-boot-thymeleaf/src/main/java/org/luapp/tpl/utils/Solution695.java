package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/04
 **/
public class Solution695 {

    public static int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j != grid[i].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }

        return ans;
    }

    public static int dfs(int[][] grid, int curI, int curJ) {

        if (curI < 0 || curJ < 0 || curI >= grid.length || curJ >= grid[0].length || grid[curI][curJ] == 0) {
            return 0;
        }

        grid[curI][curJ] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};

        int ans = 1;
        for (int idx = 0; idx < 4; idx++) {
            int nextI = curI + di[idx], nextJ = curJ + dj[idx];
            ans += dfs(grid, nextI, nextJ);
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(maxAreaOfIsland(new int[][]{
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
        System.out.println(maxAreaOfIsland(new int[][]{
                new int[]{0, 0, 0, 0, 0, 0, 0, 0},
        }));
    }
}
