package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution342 {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 1431655765) > 0;
    }

    public static boolean isPowerOfFour2(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public static boolean isPowerOfFour3(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n % 3) == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(6));
        System.out.println(isPowerOfTwo(7));
        System.out.println(isPowerOfTwo(8));

        System.out.println(isPowerOfFour(4));
        System.out.println(isPowerOfFour(8));
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(32));
        System.out.println(isPowerOfFour(64));
    }
}
