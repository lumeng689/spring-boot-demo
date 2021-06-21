package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/06/21
 **/
public class Solution1399 {

    public static int countLargestGroup(int n) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int maxValue = 0;
        for (int i = 1; i <= n; ++i) {
            int key = 0, i0 = i;
            while (i0 != 0) {
                key += i0 % 10;
                i0 /= 10;
            }
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            maxValue = Math.max(maxValue, hashMap.get(key));
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> kvpair : hashMap.entrySet()) {
            if (kvpair.getValue() == maxValue) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
        System.out.println(countLargestGroup(2));
        System.out.println(countLargestGroup(15));
        System.out.println(countLargestGroup(24));
    }
}
