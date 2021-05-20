package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Offer021 {

    public int[] exchange(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int i = 0, j = nums.length - 1;

        while (i < j) {
            if (nums[i] % 2 == 1) {
                i++;
            }

            if (nums[j] % 2 == 0) {
                j--;
            }
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {

    }
}
