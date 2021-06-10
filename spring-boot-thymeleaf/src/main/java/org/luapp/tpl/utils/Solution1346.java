package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/10
 **/
public class Solution1346 {

    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == 2 * arr[j] || arr[j] == 2 * arr[i]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(checkIfExist(new int[]{7, 1, 14, 11}));
        System.out.println(checkIfExist(new int[]{3, 1, 7, 11}));
    }
}
