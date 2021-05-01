package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution069 {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 0, right = x, ans = -1;

        while (left <= right) {
            int mid = left + (right - 1) / 2;

            if (mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
    }
}
