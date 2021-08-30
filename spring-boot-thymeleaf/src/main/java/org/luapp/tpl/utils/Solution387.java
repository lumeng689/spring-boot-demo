package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution387 {
    public static int firstUniqChar(String s) {
        int[] chars = new int[26];
        char[] arr = s.toCharArray();

        for (char c : arr) {
            chars[c - 'a']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (chars[arr[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
