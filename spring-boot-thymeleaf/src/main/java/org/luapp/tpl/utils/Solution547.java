package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/04
 **/
public class Solution547 {

    public static int findCircleNum(int[][] isConnected) {
        int count = 0;

        if (isConnected == null || isConnected.length <= 0) {
            return count;
        }

        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i]) {
                    dfs(isConnected, i, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] isConnected, int i, boolean[] visited) {
        visited[i] = true;

        for (int k = 0; k < isConnected.length; k++) {
            if (isConnected[i][k] == 1 && !visited[k]) {
                dfs(isConnected, k, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 1, 0},
                new int[]{0, 0, 1}
        }));

        System.out.println(findCircleNum(new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 1}
        }));
    }
}
