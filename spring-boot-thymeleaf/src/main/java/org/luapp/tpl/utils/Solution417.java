package org.luapp.tpl.utils;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: 86150
 * @create: 2021/05/04
 **/
public class Solution417 {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights == null || heights.length <= 0) {
            return ans;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, canReachP, i, 0);
            dfs(heights, canReachA, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(heights, canReachP, 0, i);
            dfs(heights, canReachA, m - 1, i);
        }

        for (int i =0;i<m;i++) {
            for (int j =0;j <n;j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);

                    ans.add(item);
                }
            }
        }

        return ans;
    }

    private static void dfs(int[][] heights, boolean[][] canReach, int r, int c) {
        if (canReach[r][c]) {
            return;
        }

        canReach[r][c] = true;

        int x, y;
        int[] directions = new int[]{-1, 0, 1, 0, -1};

        for (int i = 0; i < directions.length - 1; i++) {
            x = r + directions[i];
            y = c + directions[i + 1];

            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && heights[r][c] <= heights[x][y]) {
                dfs(heights, canReach, x, y);
            }
        }
    }

    public static void main(String[] args) {
        Util.printNestList(pacificAtlantic(new int[][]{
                new int[]{1, 2, 2, 3, 5},
                new int[]{3, 2, 3, 4, 4},
                new int[]{2, 4, 5, 3, 1},
                new int[]{6, 7, 1, 4, 5},
                new int[]{5, 1, 1, 2, 4},
        }));
    }
}
