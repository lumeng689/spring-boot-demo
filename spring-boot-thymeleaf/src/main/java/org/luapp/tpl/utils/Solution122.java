package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/06
 **/
public class Solution122 {

    public static int maxProfit1(int[] prices) {
        int ans = 0;

        int n = prices.length;

        for (int i = 1; i < n; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }

        return ans;
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        //  dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润
        //  dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit1(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit1(new int[]{7, 6, 4, 3, 1}));

        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }
}
