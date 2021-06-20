package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/14
 **/
public class Solution1752 {

    public static boolean check0(int[] nums) {
        int n = nums.length;
        //有经过轮转
        boolean isCount = nums[0] >= nums[n - 1];

        for (int i = 1; i < n; i++) {

            if (nums[i] < nums[i - 1]) {
                if (isCount) {
                    isCount = false;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean check(int[] nums) {

        int idx = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                idx = i + 1;
                break;
            }
        }

        if (idx == -1) {
            return false;
        }

        for (int i = idx; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{3, 4, 5, 1, 2}));
        System.out.println(check(new int[]{2, 1, 3, 4}));
        System.out.println(check(new int[]{1, 2, 3}));
        System.out.println(check(new int[]{1, 1, 1}));
        System.out.println(check(new int[]{2, 1}));
    }
}
