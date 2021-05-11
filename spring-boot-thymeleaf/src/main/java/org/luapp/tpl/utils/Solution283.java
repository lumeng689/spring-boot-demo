package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/11
 **/
public class Solution283 {

    public static void moveZeroes1(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            while (nums[j] == 0 && j > 0) {
                j--;
            }

            while (nums[i] != 0 && i < nums.length - 1) {
                i++;
            }

            if (i < j) {
                for (int k = i; k < j; k++) {
                    nums[k] = nums[k + 1];
                }
                nums[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
//        moveZeroes(new int[]{0, 0});
        moveZeroes(new int[]{2, 1});
    }
}
