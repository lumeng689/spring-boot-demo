package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution344 {

    public static void reverseString(char[] s) {

        if (s == null || s.length <= 1) {
            return;
        }

        int i = 0, j = s.length - 1;

        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }
}
