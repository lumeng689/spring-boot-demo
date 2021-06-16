package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/06/15
 **/
public class Offer057 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], false);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.containsKey(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Util.printArray(twoSum(new int[]{2, 7, 11, 15}, 9));
        Util.printArray((twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40)));
    }
}
