package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution198 {

    public static int rob(int[] nums) {

        int[] reward = new int[nums.length];

        for (int i = 0; i < reward.length; i++) {
            if (i == 0 ) {
                reward[i] = nums[i];
            } else if (i == 1) {
                reward[i] = Math.max(nums[i-1], nums[i]);
            } else {
                reward[i] = Math.max(reward[i - 1], reward[i - 2] + nums[i]);
            }
        }

        int max = 0;
        for (int i = 0; i < reward.length; i++) {
            if (max < reward[i]) {
                max = reward[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(rob(new int[]{1, 2, 3, 1}));
//        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }
}
