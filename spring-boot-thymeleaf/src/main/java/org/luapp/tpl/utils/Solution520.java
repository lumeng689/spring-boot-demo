package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/21
 **/
public class Solution520 {

    public static boolean detectCapitalUse(String word) {
        int l = word.length();
        int z = 0;
        for (int i = 0; i < l; i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                z++;
            }
        }
        if (z == l || (word.charAt(0) >= 65 && word.charAt(0) <= 90 && z == 1) || z == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
    }
}
