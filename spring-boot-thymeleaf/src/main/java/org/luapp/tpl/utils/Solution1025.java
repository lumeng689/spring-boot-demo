package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Solution1025 {

    public static boolean divisorGame1(int n) {
        return n % 2 == 0;
    }

    public static boolean divisorGame2(int n) {
        boolean[] f = new boolean[n + 5];

        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(divisorGame1(2));
        System.out.println(divisorGame2(2));
        System.out.println(divisorGame1(3));
        System.out.println(divisorGame2(3));
    }
}
