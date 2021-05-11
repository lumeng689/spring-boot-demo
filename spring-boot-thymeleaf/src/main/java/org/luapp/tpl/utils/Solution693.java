package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/10
 **/
public class Solution693 {

    public static boolean hasAlternatingBits(int n) {

        while(n > 0) {
            int r = n %2;
            n = n /2;

            if (r == n %2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
        System.out.println(hasAlternatingBits(3));
    }
}
