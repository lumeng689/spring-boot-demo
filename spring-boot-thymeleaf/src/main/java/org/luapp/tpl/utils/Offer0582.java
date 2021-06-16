package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/16
 **/
public class Offer0582 {

    public static String reverseLeftWords1(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public static String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static String reverseLeftWords3(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }

    public static String reverseLeftWords4(String s, int n) {
        return "";
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords1("abcdefg", 2));
        System.out.println(reverseLeftWords1("lrloseumgh", 6));
    }
}
