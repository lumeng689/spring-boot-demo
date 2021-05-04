package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/03
 **/
public class Solution072 {

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) {
            return n + m;
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1] ;

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }

                dp[i][j] = Math.min(left, Math.min(down, leftDown));
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }
}
