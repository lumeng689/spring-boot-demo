package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/05/30
 **/
public class Solution560 {

    public static int subarraySum1(int[] nums, int k) {

        int count = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }


        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];

            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }

            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
