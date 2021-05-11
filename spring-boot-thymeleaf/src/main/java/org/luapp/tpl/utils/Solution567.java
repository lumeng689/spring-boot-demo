package org.luapp.tpl.utils;

import java.util.Arrays;

/**
 * @author: 86150
 * @create: 2021/04/29
 **/
public class Solution567 {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        int n = s1.length(), m = s2.length();

        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a'] += 1;
            cnt2[s2.charAt(i) - 'a'] += 1;
        }

        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = n; i < m; i++) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
