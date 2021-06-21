package org.luapp.tpl.utils;

import java.util.Arrays;

/**
 * @author: 86150
 * @create: 2021/06/21
 **/
public class Solution575 {

    public static int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int ans = 0;

        int preType = -1;
        for (int i = 0; i < candyType.length; i++) {
            if (candyType[i] == preType) {
                continue;
            } else {
                preType = candyType[i];
                ans++;
            }
        }

        if (ans > candyType.length / 2) {
            ans = candyType.length / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(distributeCandies(new int[]{1, 1, 2, 3}));
    }
}
