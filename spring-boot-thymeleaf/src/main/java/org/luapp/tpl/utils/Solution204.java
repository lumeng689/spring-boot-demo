package org.luapp.tpl.utils;

import java.util.Arrays;

/**
 * @author: 86150
 * @create: 2021/06/19
 **/
public class Solution204 {

    public static int countPrimes(int n) {
        int ans = 0;

        if (n < 2) {
            return 0;
        }

        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }

        return ans;
    }

    public int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }


    public static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
    }
}
