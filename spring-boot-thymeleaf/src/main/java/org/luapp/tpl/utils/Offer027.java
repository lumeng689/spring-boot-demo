package org.luapp.tpl.utils;

import java.util.Arrays;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer027 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);

        int[] ans = new int[k];

        for (int i =0;i < k;i++) {
            ans[i] = arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
