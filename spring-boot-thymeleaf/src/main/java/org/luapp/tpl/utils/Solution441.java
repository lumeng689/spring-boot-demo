package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/30
 **/
public class Solution441 {

    public static int arrangeCoins(int n) {

        if (n <= 0) {
            return 0;
        }

        int row = 0;
        while (n > 0) {
            row++;
            n -= row;
        }

        if(n ==0) {
            return row;
        } else {
            return row-1;
        }
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(1));
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
    }
}
