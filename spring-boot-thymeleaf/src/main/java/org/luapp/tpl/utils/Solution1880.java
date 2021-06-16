package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Solution1880 {

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int a = convertToInt(firstWord);
        int b = convertToInt(secondWord);
        int c = convertToInt(targetWord);

        return a + b == c;
    }

    public static int convertToInt(String word) {
        int ans = 0;

        if (word == null || word.length() <= 0) {
            return ans;
        }

        for (int i = 0; i < word.length(); i++) {
            ans *= 10;
            int c = word.charAt(i) - 'a';
            ans += c;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isSumEqual("acb", "cba", "cdb"));
        System.out.println(isSumEqual("aaa", "a", "aab"));
    }
}
