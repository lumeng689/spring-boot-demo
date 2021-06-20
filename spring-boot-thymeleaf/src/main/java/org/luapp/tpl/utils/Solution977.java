package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Solution977 {

    public static int[] sortedSquares0(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // 开头和结尾进行比较， 最大值一定是位于开头或者结尾的地方
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }


    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];

        int minAbsIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(nums[minAbsIndex])) {
                minAbsIndex = i;
            }
        }

        if (minAbsIndex == 0) {
            int j = 0;
            for (int num : nums) {
                ans[j++] = num * num;
            }
        } else if (minAbsIndex == nums.length - 1) {
            int j = nums.length - 1;
            for (int num : nums) {
                ans[j--] = num * num;
            }
        } else {
            int left = minAbsIndex - 1;
            int right = minAbsIndex + 1;

            int pos = 0;
            ans[pos++] = nums[minAbsIndex] * nums[minAbsIndex];

            while (left >= 0 || right <= nums.length - 1) {
                int leftValue = left >= 0 ? Math.abs(nums[left]) : Integer.MAX_VALUE;
                int rightValue = right <= nums.length - 1 ? Math.abs(nums[right]) : Integer.MAX_VALUE;

                if (leftValue < rightValue) {
                    ans[pos++] = leftValue * leftValue;
                    left--;
                } else {
                    ans[pos++] = rightValue * rightValue;
                    right++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        Util.printArray(sortedSquares(new int[]{-4, -1, 0, 3, 10}));
//        Util.printArray(sortedSquares(new int[]{-7, -3, 2, 3, 11}));
        Util.printArray(sortedSquares(new int[]{-1, 2, 2}));
    }
}
