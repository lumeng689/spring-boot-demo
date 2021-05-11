package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/11
 **/
public class Solution1734 {

    public static int[] decode(int[] encoded) {
        int n = encoded.length + 1;

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total = total ^ i;
        }

        int odd = 0;
        for (int i =1;i < n-1;i=i+2) {
            odd = odd ^ encoded[i];
        }

        int[] perm = new int[n];
        perm[0] = total ^ odd;
        for (int i =1;i <n;i++) {
            perm[i] = perm[i-1] ^ encoded[i-1];
        }

        return perm;
    }

    public static void main(String[] args) {
        Util.printArray(decode(new int[]{3, 1}));
        Util.printArray(decode(new int[]{6, 5, 4, 6}));
    }
}
