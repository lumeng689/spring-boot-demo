package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution482 {

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        char[] chars = s.toUpperCase().toCharArray();
        int j = chars.length - 1;
        int t = 0;

        while (j >= 0) {
            while (j >= 0 && chars[j] == '-') {
                j--;
            }

            if (j < 0) {
                break;
            }

            if (t == k) {
                sb.append("-");
                t = 0;
            }
            t++;
            sb.append(chars[j--]);
        }


        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
    }
}
