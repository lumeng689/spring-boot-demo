package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/28
 **/
public class Solution415 {

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;

        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;

            i--;
            j--;
        }

        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("11", "22"));
    }
}
