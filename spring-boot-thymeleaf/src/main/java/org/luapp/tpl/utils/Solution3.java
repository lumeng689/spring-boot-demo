package org.luapp.tpl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 86150
 * @create: 2020/06/22
 **/
public class Solution3 {

    /**
     * 爬楼梯
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int c = 0;

        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 最大子序和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int preMax = nums[0];
        int curMax = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i] + preMax) {
                preMax = nums[i];
            } else {
                preMax = nums[i] + preMax;
            }

            if (preMax > max) {
                max = preMax;
            }
        }

        return max;
    }

    /**
     * 打家劫舍
     * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/23/dynamic-programming/57/
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        Solution3 slt = new Solution3();
//        System.out.println(slt.climbStairs(0));
//        System.out.println(slt.climbStairs(1));
//        System.out.println(slt.climbStairs(2));
//        System.out.println(slt.climbStairs(3));
//        System.out.println(slt.climbStairs(4));

//        System.out.println(slt.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println(slt.rob(new int[]{1,2,3,1}));
        System.out.println(slt.rob(new int[]{2,7,9,3,1}));
    }
}
