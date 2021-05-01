package org.luapp.tpl.utils;

import java.util.Arrays;

/**
 * @author: 86150
 * @create: 2021/04/30
 **/
public class Solution455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int i = 0;
        int j = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                cnt++;
            } else {
                j++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
//        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(findContentChildren(new int[]{10, 9, 8,7}, new int[]{5,6,7,8}));
    }
}
