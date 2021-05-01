package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/04/28
 **/
public class Solution004 {

    public static double findMedianSortedArray(int[] nums) {
        if (nums.length % 2 == 0) {
            int i1 = nums.length / 2;
            int i2 = i1 - 1;

            return (nums[i1] + nums[i2]) / 2.0;
        } else {
            return nums[(nums.length / 2)];
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }

        if (nums1.length == 0 && nums2.length > 0) {
            return findMedianSortedArray(nums2);
        }

        if (nums1.length > 0 && nums2.length == 0) {
            return findMedianSortedArray(nums1);
        }

        int[] nums = new int[nums1.length + nums2.length];

        int i1 = 0, i2 = 0, k = 0;

        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2]) {
                nums[k++] = nums1[i1++];
            } else {
                nums[k++] = nums2[i2++];
            }
        }

        if (i1 < nums1.length ) {
            System.arraycopy(nums1, i1, nums, k, nums1.length - i1);
        } else {
            System.arraycopy(nums2, i2, nums, k, nums2.length - i2);
        }

        return findMedianSortedArray(nums);
    }

    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
//        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
//        System.out.println(findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
//        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
//        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{1}));
    }
}
