package org.luapp.tpl.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution345 {

    Set<Character> chars = new HashSet<>();

    public static String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (i < chars.length && !isVowelChar(chars[i])) {
                i++;
            }

            while (j > 0 && !isVowelChar(chars[j])) {
                j--;
            }

            if (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
            i++;
            j--;
        }

        return String.valueOf(chars);
    }

    public static boolean isVowelChar(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
//        System.out.println(reverseVowels("hello"));
//        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels(".,"));
    }
}
