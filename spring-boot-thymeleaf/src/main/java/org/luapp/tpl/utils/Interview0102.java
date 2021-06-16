package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/06/14
 **/
public class Interview0102 {

    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);

            if (!countMap.containsKey(c)) {
                return false;
            }

            int count = countMap.get(c);
            if (count <= 0) {
                return false;
            }

            countMap.put(c, count - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc", "bca"));
        System.out.println(CheckPermutation("abc", "bad"));
    }
}
