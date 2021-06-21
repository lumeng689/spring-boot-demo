package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/21
 **/
public class Solution944 {

    public static int minDeletionSize(String[] strs) {
        int ans = 0;

        int m = strs.length;
        int n = strs[0].length();

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m - 1; i++) {
//                System.out.printf("c1: %c,c2:%c \n", strs[i + 1].charAt(j), strs[i].charAt(j));
                if (strs[i + 1].charAt(j) - strs[i].charAt(j) < 0) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"cba","daf","ghi"}));
        System.out.println(minDeletionSize(new String[]{"a","b"}));
        System.out.println(minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
        System.out.println(minDeletionSize(new String[]{"rrjk", "furt", "guzm"}));
    }
}
