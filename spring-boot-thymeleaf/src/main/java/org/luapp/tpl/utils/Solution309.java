package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/04
 **/
public class Solution309 {

    public static int maxProfit1(int[] prices) {

        if (prices == null || prices.length <= 0) {
            return 0;
        }

        int n = prices.length;

        int[] buy = new int[n], sell = new int[n], s1 = new int[n], s2 = new int[n];

        s1[0] = buy[0] = -prices[0];
        sell[0] = s2[0] = 0;

        for (int i = 1; i < n; i++) {
            buy[i] = s2[i - 1] - prices[i];
            s1[i] = Math.max(buy[i - 1], s1[i - 1]);
            sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i];
            s2[i] = Math.max(s2[i - 1], sell[i - 1]);
        }

        return Math.max(s2[n - 1], sell[n - 1]);
    }

    /**
     * 第二种解法
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int sold = 0;
        int rest = 0;
        int hold = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int preSold = sold;
            sold = hold + prices[i];
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, preSold);
        }

        return Math.max(rest, sold);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{1, 2, 3, 0, 2}));
        System.out.println(maxProfit2(new int[]{1, 2, 3, 0, 2}));
    }
}
