package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Solution1790 {

    public static boolean areAlmostEqual(String s1, String s2) {

        if (s1 == null && s2 == null || s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int i1 = -1;
        int i2 = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (i1 == -1) {
                    i1 = i;
                } else if (i2 == -1) {
                    i2 = i;
                } else {
                    return false;
                }
            }
        }

        if (i1 == -1 || i2 == -1) {
            return false;
        }

        return s1.charAt(i2) == s2.charAt(i1) && s1.charAt(i1) == s2.charAt(i2);
    }

    public static void main(String[] args) {
//        System.out.println(areAlmostEqual("bank", "kanb"));
//        System.out.println(areAlmostEqual("attack", "defend"));
//        System.out.println(areAlmostEqual("kelb", "kelb"));
//        System.out.println(areAlmostEqual("abcd", "dcba"));
        System.out.println(areAlmostEqual("aa", "ac"));
    }
}
