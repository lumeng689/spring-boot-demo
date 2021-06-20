package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/19
 **/
public class Interview1617 {

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5}));
//        System.out.println(maxSubArray(new int[]{1}));
//        System.out.println(maxSubArray(new int[]{-1}));
//        System.out.println(maxSubArray(new int[]{-2147483647}));
        System.out.println(maxSubArray(new int[]{-2, 1}));
    }
}
