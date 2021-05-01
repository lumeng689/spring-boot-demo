package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/04/30
 **/
public class Solution209 {
    public static int minSubArrayLen(int target, int[] nums) {

        int minNum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            int t = i + 1;
            while (t < nums.length && remain > 0) {
                remain = remain - nums[t];
                t++;
            }

            if (remain <= 0) {
                if (t - i < minNum) {
                    minNum = t - i;
                }
                continue;
            }
        }

        if (minNum != Integer.MAX_VALUE) {
            return minNum;
        }

        return 0;
    }

    public static int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
//        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
//        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
//        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));
//        System.out.println(minSubArrayLen2(11, new int[]{1, 2, 3, 4, 5}));
    }
}
