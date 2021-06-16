package org.luapp.tpl.utils;

import org.mvel2.util.Make;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Solution1556 {

    public static String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            return "0";
        }

        int cnt = 1;
        while (n > 0) {
            if (cnt > 3) {
                sb.append('.');
                cnt = 1;
            }
            cnt++;
            sb.append(n % 10);
            n = n / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(thousandSeparator(987));
        System.out.println(thousandSeparator(1234));
        System.out.println(thousandSeparator(123456789));
        System.out.println(thousandSeparator(0));
    }
}
