package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/05/03
 **/
public class Solution290 {

    public static boolean wordPattern(String pattern, String s) {

        if (pattern == null || s == null) {
            return false;
        }

        String[] list = s.split(" ");

        if (pattern.length() != list.length) {
            return false;
        }

        Map<Character, String> hash = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String item = list[i];
            if (hash.containsKey(c)) {
                if (hash.get(c).equals(item)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (hash.containsValue(item)) {
                    return false;
                }

                hash.put(c, item);
            }
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
