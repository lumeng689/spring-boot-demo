package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/09
 **/
public class Solution1716 {

    public static int totalMoney(int n) {
        int sum = 0;
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= 7) {
                ans[i] = i;
            } else {
                ans[i] = ans[i - 7] + 1;
            }
            sum += ans[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(4));
        System.out.println(totalMoney(10));
        System.out.println(totalMoney(20));
    }
}
