package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/28
 **/
public class Solution477 {

    public static int totalHammingDistance1(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }

    public static int totalHammingDistance2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(totalHammingDistance1(new int[]{4, 14, 2}));
        System.out.println(totalHammingDistance2(new int[]{4, 14, 2}));
    }
}
