package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/02
 **/
public class Solution413 {

    public static int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int res = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count++;
                res += count;
            } else {
                count = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
