package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/20
 **/
public class Solution1523 {

    public static int countOdds(int low, int high) {
        int ans = 0;

        if (low % 2 == 1) {
            ans++;
            low++;
        }

        if (high % 2 == 1 && low <= high) {
            ans++;
            high--;
        }

        if (low <= high) {
            ans += (high - low) / 2;
        }
        return ans;
    }

    public static int countOdds2(int low, int high) {
        return pre(high) - pre(low - 1);
    }

    public static int pre(int x) {
        return (x + 1) >> 1;
    }

    public static void main(String[] args) {
        System.out.println(countOdds(3, 7));
        System.out.println(countOdds(8, 10));
        System.out.println(countOdds(3, 3));
        System.out.println(countOdds(8, 14));
    }
}
