package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Solution1207 {

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
        for (int x : arr) {
            occur.put(x, occur.getOrDefault(x, 0) + 1);
        }
        Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == occur.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(uniqueOccurrences(new int[]{1, 2}));
        System.out.println(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }
}
