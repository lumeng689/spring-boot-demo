package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Solution476 {

    public static int findComplement(int num) {
        int maxBitNum = 0;
        int tmpNum = num;
        while (tmpNum > 0) {
            maxBitNum += 1;
            tmpNum >>= 1;
        }
        return num ^ ((1 << maxBitNum) - 1);
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }
}
