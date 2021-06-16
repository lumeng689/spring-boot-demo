package org.luapp.tpl.utils;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Solution414 {

    public static int thirdMax1(int[] nums) {
        TreeSet<Integer> set=new TreeSet();
        for(int i:nums){
            set.add(i);
            if(set.size()>3){
                set.pollFirst();
            }
        }
        if(set.size()<3){
            return set.pollLast();
        }else{
            return set.pollFirst();
        }
    }
    public static int thirdMax2(int[] nums) {
        Arrays.sort(nums);

        int k = 3;
        int j = nums.length - 1;
        int lastNum = Integer.MIN_VALUE;

        while (j >= 0 && k > 0) {
            if (nums[j] != lastNum) {
                lastNum = nums[j];
                k--;
            }

            j--;
        }

        if (k > 0) {
            return nums[nums.length - 1];
        } else {
            return nums[j+1];
        }
    }

    public static void main(String[] args) {
        System.out.println(thirdMax1(new int[]{3, 2, 1}));
        System.out.println(thirdMax2(new int[]{3, 2, 1}));
        System.out.println(thirdMax1(new int[]{1, 2}));
        System.out.println(thirdMax2(new int[]{1, 2}));
        System.out.println(thirdMax1(new int[]{2, 2, 3, 1}));
        System.out.println(thirdMax2(new int[]{2, 2, 3, 1}));
    }
}
