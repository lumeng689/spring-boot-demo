package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/06/17
 **/
public class Offer050 {

    public static char firstUniqChar(String s) {
        if (s == null || s.length() <= 0) {
            return ' ';
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (countMap.get(c) == 1) {
                return c;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
        System.out.println(firstUniqChar(""));
    }
}
