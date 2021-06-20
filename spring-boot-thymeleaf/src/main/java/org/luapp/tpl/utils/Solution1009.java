package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Solution1009 {

    public static int bitwiseComplement(int n) {
        return  n == 0 ? 1 : (-1 >>> Integer.numberOfLeadingZeros(n)) - n;
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
        System.out.println(bitwiseComplement(7));
        System.out.println(bitwiseComplement(10));
    }
}
