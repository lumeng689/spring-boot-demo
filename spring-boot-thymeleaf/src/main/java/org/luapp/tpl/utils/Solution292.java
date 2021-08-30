package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution292 {

    public static boolean canWinNim(int n) {
        boolean[] ans = new boolean[n + 1];

        if (n < 4) {
            return true;
        } else {
            ans[1] = true;
            ans[2] = true;
            ans[3] = true;
            for (int i = 4; i <= n; i++) {
                ans[i] = !ans[i - 1] || !ans[i - 2] || !ans[i - 3];
            }
            return ans[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(canWinNim(4));
//        System.out.println(canWinNim(1));
//        System.out.println(canWinNim(2));
        System.out.println(canWinNim(5));
    }
}
