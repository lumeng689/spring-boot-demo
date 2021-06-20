package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/19
 **/
public class Solution405 {

    public static String toHex(int num) {
        char[] code = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int idx;
        while (num != 0) {
            idx = num & 15;
            sb.insert(0, code[idx]);
            num >>>= 4;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(0));
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
    }
}
