package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer015 {

    public static int hammingWeight(int n) {
        int ans = 0;

        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(1));
        System.out.println(hammingWeight(2));
        System.out.println(hammingWeight(3));
    }
}
