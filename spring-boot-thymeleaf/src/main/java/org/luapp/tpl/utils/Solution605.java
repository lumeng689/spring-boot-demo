package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/08
 **/
public class Solution605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int max = 0;
        int len = flowerbed.length;

        if (flowerbed.length <= 0) {
            max = 0;
        } else if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                max = 1;
            } else {
                max = 0;
            }
        } else {
            for (int i = 0; i < len; i++) {

                if (flowerbed[i] == 1) {
                    continue;
                }

                if (i == 0) {
                    if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                        flowerbed[i] =1;
                        max++;
                    }
                    continue;
                }

                if (flowerbed[i - 1] == 1 || (i + 1 < len && flowerbed[i + 1] == 1)) {
                    continue;
                } else {
                    flowerbed[i] = 1;
                    max++;
                }
            }
        }

        return max >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{0, 0}, 2));
//        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
//        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }
}
