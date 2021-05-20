package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer003 {

    public static int findRepeatNumber(int[] nums) {
        int ans = -1;
        int[] counts = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]] += 1;

            if (counts[nums[i]] >= 2) {
                ans = nums[i];
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
