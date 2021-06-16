package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/13
 **/
public class Solution058 {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                ans = 0;
            } else {
                ans++;
            }
        }

        return ans;
    }

    public static int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord2("Hello World"));
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord2(" "));
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord2("a "));
    }
}
