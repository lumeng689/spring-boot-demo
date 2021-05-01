package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: 86150
 * @create: 2021/04/30
 **/
public class Solution989 {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = num.length - 1; i >= 0; i--) {
            int value = num[i] + k % 10;
            k = k / 10;
            if (value >= 10) {
                value = value % 10;
                k++;
            }
            result.add(value);
        }

        for (; k >= 1; ) {
            result.add(k%10);
            k = k / 10;
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(addToArrayForm(new int[]{1, 2, 0, 0}, 34));
//        System.out.println(addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(addToArrayForm(new int[]{0}, 10000));
    }
}
