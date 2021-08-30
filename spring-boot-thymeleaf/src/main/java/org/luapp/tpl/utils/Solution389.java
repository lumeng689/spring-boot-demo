package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution389 {

    public static char findTheDifference(String s, String t) {
        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            chars[c - 'a']--;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 0) {
                return (char)('a' + i);
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference("", "y"));
        System.out.println(findTheDifference("a", "aa"));
        System.out.println(findTheDifference("ae", "aea"));
    }
}
