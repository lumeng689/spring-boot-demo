package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/01
 **/
public class Solution034 {

    public static int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int[] searchRange2(int[] nums, int target) {

        if (nums == null || nums.length <= 0) {
            return new int[]{-1, -1};
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                low = mid;
                high = mid;

                while (low >= 0 && nums[low] == target) {
                    low--;
                }

                while (high < nums.length && nums[high] == target) {
                    high++;
                }

                return new int[]{low+1, high-1};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Util.printArray(searchRange1(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Util.printArray(searchRange1(new int[]{5, 7, 7, 8, 8, 10}, 6));
        Util.printArray(searchRange1(new int[]{}, 0));

        Util.printArray(searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Util.printArray(searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 6));
        Util.printArray(searchRange2(new int[]{}, 0));
    }
}
