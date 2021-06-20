package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/19
 **/
public class Solution1317 {

    public static int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int a = i;
            int b = n - i;

            if (!containZero(a) && !containZero(b)) {
                return new int[]{a, b};
            }
        }

        return null;
    }

    public static boolean containZero(int n) {
        while(n > 0) {
            if (n %10 == 0) {
                return true;
            }
            n = n/10;
        }

        return false;
    }

    public static void main(String[] args) {
        Util.printArray(getNoZeroIntegers(2));
        Util.printArray(getNoZeroIntegers(11));
        Util.printArray(getNoZeroIntegers(10000));
        Util.printArray(getNoZeroIntegers(69));
        Util.printArray(getNoZeroIntegers(1010));
    }
}
