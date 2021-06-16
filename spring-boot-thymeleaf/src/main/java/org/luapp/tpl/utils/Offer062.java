package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/16
 **/
public class Offer062 {

    public static int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
        System.out.println(lastRemaining(10, 17));
    }
}
