package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution367 {

    public static boolean isPerfectSquare(int num) {
        int i = 1;
        if (num == 1) {
            return true;
        }
        while (i < num) {
            if (i * i == num) {
                return true;
            } else if (i * i > num) {
                break;
            }
            i++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }
}
