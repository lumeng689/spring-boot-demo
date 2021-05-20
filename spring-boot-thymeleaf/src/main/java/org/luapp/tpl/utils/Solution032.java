package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: 86150
 * @create: 2021/05/12
 **/
public class Solution032 {
    public static int longestValidParentheses(String s) {

        char left = '(';
        char right = ')';

        if (s == null || s.length() <= 1) {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 0;
        dp[1] = s.charAt(0) == left && s.charAt(1) == right ? 2 : 0;

        int max = dp[1];

        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = s.charAt(i - 1);

            if (c1 == left && c == right) {
                // ()
                dp[i] = dp[i - 1] + 2;
            } else if (c1 == left && c == left) {
                // ((
                dp[i] = 0;
            } else if (c1 == right && c == right) {
                // ))
                dp[i] = 0;
            } else if (c1 == right && c == left) {
                // )(
                dp[i] = dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(()"));
    }
}
