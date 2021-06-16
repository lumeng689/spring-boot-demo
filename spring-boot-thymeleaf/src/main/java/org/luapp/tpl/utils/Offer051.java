package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/06/11
 **/
public class Offer051 {

    public static int reversePairs(int[] nums) {
        int ans = 0;
        for (int i =0;i < nums.length-1;i++) {
            for (int j = i+1;j < nums.length;j++) {
                if (nums[i] > nums[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4}));
    }
}
