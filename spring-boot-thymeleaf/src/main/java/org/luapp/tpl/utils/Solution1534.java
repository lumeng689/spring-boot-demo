package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/19
 **/
public class Solution1534 {

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int ans = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
        System.out.println(countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));
    }
}
