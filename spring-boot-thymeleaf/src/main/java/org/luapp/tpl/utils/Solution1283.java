package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/30
 **/
public class Solution1283 {

    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 1000000;

        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int total = 0;
            for (int num : nums) {
                total += (num - 1) / mid + 1;
            }

            if (total <= threshold) {
                ans = mid;
                right = mid -1;
            } else {
                left = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        System.out.println(smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));
        System.out.println(smallestDivisor(new int[]{19}, 5));
    }
}
