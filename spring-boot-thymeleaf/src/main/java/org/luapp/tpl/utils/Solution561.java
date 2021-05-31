package org.luapp.tpl.utils;

import java.util.Arrays;

/**
 * @author: 86150
 * @create: 2021/05/30
 **/
public class Solution561 {

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int min = 0;
        for (int i = 0; i < nums.length; i += 2) {
            min += nums[i];
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }
}
