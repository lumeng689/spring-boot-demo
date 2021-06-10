package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/05
 **/
public class Solution504 {

    public static String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        } else if (num < 7) {
            return num + "";
        }

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(0));
        System.out.println(convertToBase7(5));
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
    }
}
