package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/19
 **/
public class Solution696 {

    public static int countBinarySubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            int zeroCount = 0;
            int oneCount = 0;

            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '0') {

                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings("10101"));
    }
}
