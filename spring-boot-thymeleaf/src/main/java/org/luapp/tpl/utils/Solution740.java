package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/05
 **/
public class Solution740 {

    public static int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int maxVal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
            }
        }

        int[] all = new int[maxVal + 1];

        for (int num: nums) {
            all[num]++;
        }

        int[] dp = new int[maxVal + 1];
        dp[1] = all[1];
        dp[2] = Math.max(dp[1], all[2] * 2);

        for (int i = 3; i <= maxVal; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + all[i] * i);
        }
        return dp[maxVal];
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
