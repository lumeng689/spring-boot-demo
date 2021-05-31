package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/27
 **/
public class Solution1304 {

    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[]{0};
        }

        int[] num = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            num[i] = i;
            sum += i;
        }

        num[n - 1] = -sum;

        return num;
    }

    public static void main(String[] args) {

    }
}
