package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer017 {
    public int[] printNumbers(int n) {
        int max = 1;

        while (n-- > 0) {
            max = max * 10;
        }

        int[] ans = new int[max - 1];
        for (int i = 0; i < max - 1; i++) {
            ans[i] = i + 1;
        }

        return ans;
    }
}
