package org.luapp.tpl.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: 86150
 * @create: 2021/04/30
 **/
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ret = new int[nums.length - k + 1];


        for (int i = k - 1; i < nums.length; i++) {
            ret[i - (k - 1)] = getMax(nums, i - (k - 1), i);
        }

        return ret;
    }

    public int getMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void printArray(int[] ret) {
        if (ret == null || ret.length <= 0) {
            System.out.println("");
        }

        System.out.println(StringUtils.join(ret, ','));
    }

    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        printArray(solution239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        printArray(solution239.maxSlidingWindow(new int[]{1}, 1));
        printArray(solution239.maxSlidingWindow(new int[]{4, -2}, 2));
    }
}
