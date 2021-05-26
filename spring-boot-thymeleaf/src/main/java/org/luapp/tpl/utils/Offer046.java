package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/05/20
 **/
public class Offer046 {

    static int ans = 0;

    public static int translateNum(int num) {
        if (num == 0) {
            return ++ans;
        }
        if (num > 0) {
            translateNum(num / 10);
        }
        if (num >= 10 && num % 100 < 26 && num % 100 >= 10) {
            translateNum(num / 100);
        }
        return ans;
    }


    public static int translateNum2(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int[] dp = new int[len + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < len + 1; i++) {
            if (numStr.charAt(i - 2) == '1' || numStr.charAt(i - 2) == '2' && numStr.charAt(i - 1) < '6') {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[len];
    }


    public static void main(String[] args) {
        System.out.println(translateNum(12258));
        System.out.println(translateNum2(12258));
    }
}
