package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/12
 **/
public class Solution1310 {

    public static int[] xorQueries(int[] arr, int[][] queries) {

        if (queries == null || queries.length <= 0) {
            return new int[]{};
        }

        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            ans[k] = help(arr, queries[k][0], queries[k][1]);
        }

        return ans;
    }

    private static int help(int[] arr, int i, int j) {

        int a = arr[i];

        if (i == j) {
            return arr[i];
        }

        for (int k = i + 1; k <= j; k++) {
            a ^= arr[k];
        }

        return a;
    }

    public static int[] xorQueries2(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xors = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Util.printArray(xorQueries(new int[]{1, 3, 4, 8}, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{0, 3},
                new int[]{3, 3}
        }));
        Util.printArray(xorQueries(new int[]{4, 8, 2, 10}, new int[][]{
                new int[]{2, 3},
                new int[]{1, 3},
                new int[]{0, 0},
                new int[]{0, 3}
        }));

        Util.printArray(xorQueries2(new int[]{1, 3, 4, 8}, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{0, 3},
                new int[]{3, 3}
        }));
        Util.printArray(xorQueries2(new int[]{4, 8, 2, 10}, new int[][]{
                new int[]{2, 3},
                new int[]{1, 3},
                new int[]{0, 0},
                new int[]{0, 3}
        }));
    }
}
