package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/25
 **/
public class Solution509 {

    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }


        int a = 0, b = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
    }
}
