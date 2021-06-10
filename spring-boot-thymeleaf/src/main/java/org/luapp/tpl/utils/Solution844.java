package org.luapp.tpl.utils;

import org.mvel2.util.Make;

/**
 * @author: 86150
 * @create: 2021/05/30
 **/
public class Solution844 {

    public static boolean backspaceCompare(String s, String t) {

        if (s == null || t == null || s.length() <= 0 || t.length() <= 0) {
            return true;
        }

        String s1 = parse(s);
        String t1 = parse(t);

        return s1.equals(t1);
    }

    private static String parse(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '#') {
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
    }
}
