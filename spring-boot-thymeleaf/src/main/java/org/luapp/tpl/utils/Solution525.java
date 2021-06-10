package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/06/03
 **/
public class Solution525 {

    public static int findMaxLength(int[] nums) {

//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        if (nums.length == 1 || nums.length == 2) {
//            return nums.length;
//        }
//
//        int ans = 2;
//
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] * 2 == nums[i - 1] + nums[i + 1]) {
//                ans++;
//            } else {
//                ans = 2;
//            }
//        }
//
//        return ans;


        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 1) {
                counter++;
            } else {
                counter--;
            }

            if (map.containsKey(counter)) {
                int preIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - preIndex);
            } else {
                map.put(counter, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
    }
}
