package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/27
 **/
public class Solution461 {

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
