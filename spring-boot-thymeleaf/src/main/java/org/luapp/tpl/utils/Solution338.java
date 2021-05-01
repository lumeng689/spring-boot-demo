package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution338 {
    public static int[] countBits(int num) {

        if (num == 0) {
            return new int[]{0};
        }

        if (num == 1) {
            return new int[]{0, 1};
        }


        int[] ans = new int[num + 1];
        ans[0] = 0;
        ans[1] = 1;

        for (int i = 2; i <= num; i++) {
            if ((i & 1) == 0) {
                ans[i] = ans[i >> 1];
            } else {
                ans[i] = ans[i - 1] + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Util.printArray(countBits(2));
        Util.printArray(countBits(5));
    }
}
