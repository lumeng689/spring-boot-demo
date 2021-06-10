package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/10
 **/
public class Solution1437 {

    public static boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int prev = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k) {
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        System.out.println(kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
        System.out.println(kLengthApart(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(kLengthApart(new int[]{0, 1, 0, 1}, 1));
    }
}
