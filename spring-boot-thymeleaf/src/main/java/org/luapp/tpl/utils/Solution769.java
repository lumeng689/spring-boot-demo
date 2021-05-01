package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution769 {

    public static int maxChunksToSorted(int[] arr) {
        int chunks = 0, curMax = 0;

        for (int i = 0; i < arr.length; i++) {
            curMax = Math.max(arr[i], curMax);

            if (curMax == i) {
                chunks++;
            }
        }

        return chunks;
    }

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }
}
