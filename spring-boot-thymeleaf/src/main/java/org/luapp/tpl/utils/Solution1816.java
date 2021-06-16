package org.luapp.tpl.utils;

import org.mvel2.util.Make;

/**
 * @author: 86150
 * @create: 2021/06/13
 **/
public class Solution1816 {

    public static String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                count++;
            }
            if (count >= k) {
                break;
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
        System.out.println(truncateSentence("What is the solution to this problem", 4));
        System.out.println(truncateSentence("chopper is not a tanuki", 5));
    }
}
