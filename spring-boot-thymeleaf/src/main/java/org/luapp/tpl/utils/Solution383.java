package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/10
 **/
public class Solution383 {

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (magazine == null || magazine.length() <= 0) {
            return false;
        }

        int[] hash = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            hash[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';

            if (hash[idx] <= 0) {
                return false;
            } else {
                hash[idx]--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
