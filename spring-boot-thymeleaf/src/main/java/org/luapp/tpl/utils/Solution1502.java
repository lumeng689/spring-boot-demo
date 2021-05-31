package org.luapp.tpl.utils;

import java.util.Arrays;

/**
 * @author: 86150
 * @create: 2021/05/26
 **/
public class Solution1502 {

    public static boolean canMakeArithmeticProgression(int[] arr) {

        if (arr == null || arr.length <=0) {
            return false;
        }

        Arrays.sort(arr);

        if (arr.length <= 2) {
            return true;
        }

        int d = arr[1] - arr[0];

        for (int i = 2;i < arr.length;i++) {
            if (arr[i] - arr[i-1] != d) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[]{3, 5, 1}));
        System.out.println(canMakeArithmeticProgression(new int[]{1, 2, 4}));
    }
}
