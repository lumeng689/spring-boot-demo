package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/30
 **/
public class Solution844 {

    public static boolean backspaceCompare(String s, String t) {

        if (s == null || t == null || s.length() <= 0 || t.length() <= 0) {
            return true;
        }

        

        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
    }
}
