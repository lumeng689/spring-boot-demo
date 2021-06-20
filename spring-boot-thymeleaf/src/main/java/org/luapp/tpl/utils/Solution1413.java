package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Solution1413 {

    public static int minStartValue(int[] nums) {

        int[] sums = new int[nums.length];

        sums[0] = nums[0];
        int minValue = sums[0];

        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];

            if (sums[i] < minValue) {
                minValue = sums[i];
            }
        }

        return minValue >= 0 ? 1 : Math.abs(minValue) + 1;
    }

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(minStartValue(new int[]{1, 2}));
        System.out.println(minStartValue(new int[]{1, -2, -3}));
    }
}
