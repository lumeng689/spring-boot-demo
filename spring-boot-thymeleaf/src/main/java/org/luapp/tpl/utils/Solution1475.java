package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/25
 **/
public class Solution1475 {

    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length == 0) {
            return prices;
        }

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return prices;
    }

    public static void main(String[] args) {

    }
}
