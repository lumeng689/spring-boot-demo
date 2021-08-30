package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution326 {
    public static boolean isPowerOfThree(int n) {
        while (n >= 3) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                break;
            }
        }

        return n == 1;
    }

    public static boolean isPowerOfThree2(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(45));
    }
}
