package org.luapp.tpl.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: 86150
 * @create: 2021/05/12
 **/
public class Solution032 {
    public static int longestValidParentheses1(String s) {

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

    public static int longestValidParentheses2(String s) {
        int maxAns = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i =0;i < s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxAns = Math.max(maxAns, i-stack.peek());
                }
            }
        }


        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses1("(()"));
        System.out.println(longestValidParentheses1(")()())"));
        System.out.println(longestValidParentheses1("()(()"));

        System.out.println(longestValidParentheses2("(()"));
        System.out.println(longestValidParentheses2(")()())"));
        System.out.println(longestValidParentheses2("()(()"));
    }
}
