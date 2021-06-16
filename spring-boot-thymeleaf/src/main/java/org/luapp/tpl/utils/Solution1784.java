package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/14
 **/
public class Solution1784 {

    public static boolean checkOnesSegment(String s) {
        int n = s.length(), cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (cnt >= 1 && s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                return false;
            }
            if (s.charAt(i) == '1') {
                cnt++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkOnesSegment("1001"));
        System.out.println(checkOnesSegment("110"));
    }
}
