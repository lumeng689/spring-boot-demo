package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/14
 **/
public class Solution374 {

    public static int guess(int n) {
        return 0;
    }

    public static int guessNumber(int n) {

        int start = 1, end = n;

        while (start < end) {

            int mid = start + (end - start) / 2;

            int pick = guess(mid);

            if (pick == 0) {
                return mid;
            } else if (pick == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
        System.out.println(guessNumber(1));
        System.out.println(guessNumber(2));
        System.out.println(guessNumber(2));
    }
}
