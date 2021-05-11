package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/07
 **/
public class Solution1486 {

    public static int xorOperation(int n, int start) {

        int[] a = new int[n];

        int mask = 0;
        for (int i = 0; i < n; i++) {
            a[i] = start + 2 * i;

            if (i == 0) {
                mask = a[i];
            } else {
                mask = mask ^ a[i];
            }
        }

        return mask;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
        System.out.println(xorOperation(4, 3));
        System.out.println(xorOperation(1, 7));
        System.out.println(xorOperation(10, 5));
    }
}
