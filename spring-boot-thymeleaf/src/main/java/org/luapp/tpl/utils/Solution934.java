package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/05
 **/
public class Solution934 {

    public static int shortestBridge(int[][] A) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{
                new int[]{0, 1},
                new int[]{1, 0}
        }));

        System.out.println(shortestBridge(new int[][]{
                new int[]{0, 1, 0},
                new int[]{0, 0, 0},
                new int[]{0, 0, 1}
        }));

        System.out.println(shortestBridge(new int[][]{
                new int[]{1, 1, 1, 1, 1},
                new int[]{1, 0, 0, 0, 1},
                new int[]{1, 0, 1, 0, 1},
                new int[]{1, 0, 0, 0, 1},
                new int[]{1, 1, 1, 1, 1}
        }));
    }
}
