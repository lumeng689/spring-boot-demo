package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/21
 **/
public class Solution1108 {

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append('[');
                sb.append('.');
                sb.append(']');
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
    }
}
