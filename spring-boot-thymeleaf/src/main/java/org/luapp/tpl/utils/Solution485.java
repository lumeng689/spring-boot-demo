package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/07/11
 **/
public class Solution485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = -1;
        int seq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                seq++;
            } else {
                if (max < seq) {
                    max = seq;
                }
                seq = 0;
            }
        }
        if (max < seq) {
            max = seq;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
