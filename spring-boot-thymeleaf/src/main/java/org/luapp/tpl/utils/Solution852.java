package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Solution852 {

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2,ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        System.out.println(peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }
}
