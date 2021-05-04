package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/04
 **/
public class Solution188 {

    public static int maxProfit(int k, int[] prices) {

        int days = prices.length;

        if (days < 2) {
            return 0;
        }

        if (k >= days) {
            return maxProfitUnlimited(prices);
        }

        int[] buy = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            buy[i] = Integer.MIN_VALUE;
        }

        int[] sell = new int[k + 1];

        for (int i =0;i < days;i++) {
            for (int j = 1;j <=k;j++) {
                buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }

        return sell[k];
    }

    public static int maxProfitUnlimited(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                maxProfit = prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
