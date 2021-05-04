package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/05/03
 **/
public class Solution205 {

    public static boolean isIsomorphic(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0;i < s.length();i++) {
            char c1 =s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                char c = map.get(c1);
                if (c == c2) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            }
        }


        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isIsomorphic("egg", "add"));
//        System.out.println(isIsomorphic("foo", "bar"));
//        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
