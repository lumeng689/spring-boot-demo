package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/04
 **/
public class Solution650 {

    public static int minSteps(int n) {
        int[] dp = new int[n + 1];
        int h = Double.valueOf(Math.sqrt(n)).intValue();

        for (int i = 2; i <= n; i++) {
            dp[i] = i;

            for (int j = 2; j <= h; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minSteps(3));
        System.out.println(minSteps(7));
    }
}
