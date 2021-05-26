package org.luapp.tpl.utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: 86150
 * @create: 2021/05/20
 **/
public class Offer045 {

    public static String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{10, 2}));
        System.out.println(minNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
