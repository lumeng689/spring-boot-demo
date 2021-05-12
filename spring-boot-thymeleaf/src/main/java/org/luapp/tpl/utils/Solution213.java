package org.luapp.tpl.utils;

import java.util.Arrays;

/**
 * @author: 86150
 * @create: 2021/05/12
 **/
public class Solution213 {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        // 1. 不抢头，不抢尾
        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length - 1);
        // 2. 抢头， 不抢尾
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        // 3. 不抢头， 抢尾
        int[] nums3 = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(helper(nums1), Math.max(helper(nums2), helper(nums3)));
    }

    private int helper(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int max = Math.max(dp[0], dp[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
