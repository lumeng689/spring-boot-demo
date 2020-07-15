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
     * 买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int a = prices[j] - prices[i];

                if (a > maxProfit) {
                    maxProfit = a;
                }
            }
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int length = prices.length;
        int start = 0;
        int end = length - 1;
        int minPrice = prices[start];
        int maxPrice = prices[end];

        while (start < end) {

            while (start + 1 < length && prices[start + 1] < prices[start]) {
                start = start + 1;
                minPrice = prices[start];
            }

            while (end > start) {
                end = end - 1;

            }
        }
        return 0;
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
    public int robLow(int[] nums) {

        long start = System.currentTimeMillis();

        if (nums.length <= 0) {
            return 0;
        }

        int r = robCursive(nums, 0, -3);

        long end = System.currentTimeMillis();

        System.out.println("total seconds: " + (end - start) / 1000 * 1.0);

        return r;
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public int robCursive(int[] nums, int curIdx, int lastStealId) {

        if (curIdx >= nums.length) {
            return 0;
        }

        if (curIdx - lastStealId == 1) {
            return robCursive(nums, curIdx + 1, lastStealId);
        } else {
            // 偷这一家
            int a = nums[curIdx] + robCursive(nums, curIdx + 1, curIdx);
            // 不偷这一家
            int b = robCursive(nums, curIdx + 1, lastStealId);
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
    }

    /**
     * 最接近的三数之和
     * <p>
     * https://leetcode-cn.com/problems/3sum-closest/
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        return 0;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n;
        int idx1 = m-1;
        int idx2 = n-1;

        for (int i = total - 1; i >= 0; i--) {
            if (idx2 < 0) {
                break;
            }

            if (idx1 < 0) {
                for (int j = 0; j <= idx2; j++) {
                    nums1[j] = nums2[j];
                }
                break;
            }

            if (nums1[idx1] > nums2[idx2]) {
                nums1[i] = nums1[idx1];
                idx1--;
            } else {
                nums1[i] = nums2[idx2];
                idx2--;
            }
        }
    }

    public int firstBadVersion(int n) {
        int current = n;

        while(n > 1) {
            if (isBadVersion(n) && isBadVersion(n-1)) {
                return n;
            }
        }

        return n;
    }

    boolean isBadVersion(int version){
        if (version == 10) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution3 slt = new Solution3();
//        System.out.println(slt.climbStairs(0));
//        System.out.println(slt.climbStairs(1));
//        System.out.println(slt.climbStairs(2));
//        System.out.println(slt.climbStairs(3));
//        System.out.println(slt.climbStairs(4));

//        System.out.println(slt.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

//        System.out.println(slt.rob(new int[]{1, 2, 3, 1}));
//        System.out.println(slt.rob(new int[]{2, 7, 9, 3, 1}));
//        System.out.println(slt.rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));


//        System.out.println(slt.maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(slt.maxProfit1(new int[]{7, 6, 4, 3, 1}));
//
//        System.out.println(slt.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(slt.maxProfit2(new int[]{7, 6, 4, 3, 1}));
//        System.out.println(slt.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));

//        slt.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        System.out.println(slt.firstBadVersion(20));
        System.out.println(slt.firstBadVersion(50));
        System.out.println(slt.firstBadVersion(5));
    }
}
