package org.luapp.tpl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 86150
 * @create: 2021/05/15
 **/
public class Solution013 {

    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public static int romanToInt2(String s) {

        if (s == null || s == "") {
            return 0;
        }

        Map<String, Integer> symbols = new HashMap<>();
        symbols.put("I", 1);
        symbols.put("IV", 4);
        symbols.put("V", 5);
        symbols.put("IX", 9);
        symbols.put("X", 10);
        symbols.put("XL", 40);
        symbols.put("L", 50);
        symbols.put("XC", 90);
        symbols.put("C", 100);
        symbols.put("CD", 400);
        symbols.put("D", 500);
        symbols.put("CM", 900);
        symbols.put("M", 1000);

        int i = s.length() - 1;
        int ans = 0;
        while (i >= 0) {
            char c = s.charAt(i);

            if (i - 1 >= 0) {
                char c1 = s.charAt(i - 1);
                String s1 = String.valueOf(c);
                String s2 = String.valueOf(new char[]{c1, c});

                if (symbols.containsKey(s2)) {
                    ans += symbols.get(s2);
                    i = i - 2;
                } else {
                    ans += symbols.get(s1);
                    i--;
                }
            } else {
                ans += symbols.get(String.valueOf(c));
                i--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println();
        System.out.println(romanToInt2("III"));
        System.out.println(romanToInt2("IV"));
        System.out.println(romanToInt2("IX"));
        System.out.println(romanToInt2("LVIII"));
        System.out.println(romanToInt2("MCMXCIV"));
    }
}
