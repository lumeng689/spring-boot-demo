package org.luapp.tpl.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/06/18
 **/
public class Solution268 {

    public static int missingNumber1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }

        return 0;
    }

    public static int missingNumber2(int[] nums) {
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }

        return missing;
    }

    public static int missingNumber3(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber1(new int[]{3, 0, 1}));
        System.out.println(missingNumber2(new int[]{3, 0, 1}));
        System.out.println(missingNumber3(new int[]{3, 0, 1}));
        System.out.println(missingNumber1(new int[]{0, 1}));
        System.out.println(missingNumber2(new int[]{0, 1}));
        System.out.println(missingNumber3(new int[]{0, 1}));
        System.out.println(missingNumber1(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(missingNumber3(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(missingNumber1(new int[]{0}));
        System.out.println(missingNumber2(new int[]{0}));
        System.out.println(missingNumber3(new int[]{0}));
    }
}
