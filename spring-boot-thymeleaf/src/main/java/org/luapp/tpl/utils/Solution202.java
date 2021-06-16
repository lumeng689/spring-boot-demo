package org.luapp.tpl.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/06/10
 **/
public class Solution202 {

    public static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }

        return totalSum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> ss = new HashSet<>();
        while (n != 1 && !ss.contains(n)) {
            ss.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
}
