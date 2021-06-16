package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/13
 **/
public class Solution1455 {

    public static int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence == null || searchWord == null || sentence.length() == 0 || searchWord.length() == 0) {
            return -1;
        }

        int word = 1;
        int j = 0;
        boolean match = true;

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ') {
                word++;
                j = 0;
                match = true;
                continue;
            }

            if (!match) {
                continue;
            }

            if (c != searchWord.charAt(j)) {
                match = false;
            } else {
                j++;

                if (j >= searchWord.length()) {
                    break;
                }
            }
        }

        if (!match) {
            return -1;
        }

        return word;
    }

    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(isPrefixOfWord("i am tired", "you"));
        System.out.println(isPrefixOfWord("i use triple pillow", "pill"));
        System.out.println(isPrefixOfWord("hello from the other side", "they"));
    }
}
