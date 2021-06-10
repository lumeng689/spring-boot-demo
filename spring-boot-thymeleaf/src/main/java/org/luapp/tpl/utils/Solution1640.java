package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/06/05
 **/
public class Solution1640 {

    public static boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, int[]> map = new HashMap<>();
        for (int[] p : pieces) {
            map.put(p[0], p);
        }
        int i = 0;
        while (i < arr.length) {
            if (map.containsKey(arr[i])) {
                //通过key获取到该一维数组
                int[] priece = map.get(arr[i]);
                for (int val : priece) {
                    if (arr[i] == val) {
                        i++;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFormArray(new int[]{85}, new int[][]{
                new int[]{85}
        }));

        System.out.println(canFormArray(new int[]{15, 88}, new int[][]{
                new int[]{88},
                new int[]{15}
        }));

        System.out.println(canFormArray(new int[]{49, 18, 16}, new int[][]{
                new int[]{16, 18, 49},
        }));

        System.out.println(canFormArray(new int[]{91, 4, 64, 78}, new int[][]{
                new int[]{78},
                new int[]{4, 64},
                new int[]{91}
        }));

        System.out.println(canFormArray(new int[]{1, 3, 5, 7}, new int[][]{
                new int[]{2, 4, 6, 8}
        }));
    }
}
