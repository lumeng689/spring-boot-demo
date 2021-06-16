package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/13
 **/
public class Solution557 {

    public static String reverseWords(String s) {
        int start = 0;
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == ' ') {
                swap(array, start, i - 1);
                start = i + 1;
            }

            if (i == array.length - 1) {
                swap(array, start, i);
            }
        }

        return String.valueOf(array);
    }

    private static void swap(char[] array, int start, int end) {
        while (start < end) {
            char c = array[start];
            array[start] = array[end];
            array[end] = c;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
