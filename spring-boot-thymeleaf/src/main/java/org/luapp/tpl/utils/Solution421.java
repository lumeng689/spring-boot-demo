package org.luapp.tpl.utils;

/**
 * @author: 86150
 * @create: 2021/05/16
 **/
public class Solution421 {

    public static int findMaximumXOR1(int[] nums) {
        int ans = 0;


        return ans;
    }

    public static int findMaximumXOR2(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(ans, nums[i] ^ nums[j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumXOR1(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(findMaximumXOR1(new int[]{0}));
        System.out.println(findMaximumXOR1(new int[]{2, 4}));
        System.out.println(findMaximumXOR1(new int[]{8, 10, 2}));
        System.out.println(findMaximumXOR1(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));

        System.out.println(findMaximumXOR2(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(findMaximumXOR2(new int[]{0}));
        System.out.println(findMaximumXOR2(new int[]{2, 4}));
        System.out.println(findMaximumXOR2(new int[]{8, 10, 2}));
        System.out.println(findMaximumXOR2(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }
}
