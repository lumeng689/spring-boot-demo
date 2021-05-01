package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/04/30
 **/
public class Solution135 {
    public static int candy(int[] ratings) {

        int n = ratings.length;
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                c[i] = c[i - 1] + 1;
            } else {
                c[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && c[i] <= c[i + 1]) {
                c[i] = c[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += c[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}));
        System.out.println(candy(new int[]{1, 2, 2}));
    }
}
